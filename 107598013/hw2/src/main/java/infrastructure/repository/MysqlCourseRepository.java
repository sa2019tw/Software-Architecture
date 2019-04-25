package infrastructure.repository;

import core.boundary.require.ICourseRepository;
import core.entity.Course;
import core.entity.UnhandleException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MysqlCourseRepository implements ICourseRepository {
    private DataSource dataSource;

    public MysqlCourseRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addCourse(Course course) {
        if (!isLegalCourse(course))
            return -1;

        final String sql = "insert into course (title, description, suitable_people, price, announcement, remark)" +
                "values (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setupPreparedStatementAttributes(stmt, course);
            int rowEffected = stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();
            if (rowEffected > 0 && resultSet.next())
                return resultSet.getInt(1);
            return -1;
        } catch (SQLException e) {
            throw new UnhandleException("Persistence insert error", e);
        }
    }

    @Override
    public int updateCourse(Course course) {
        if (!isLegalCourse(course) || !isLegalCourseId(course.getId()))
            return -1;

        final String sql = "update course set " +
                                "title=?, " +
                                "description=?, " +
                                "suitable_people=?, " +
                                "price=?, " +
                                "announcement=?, " +
                                "remark=? " +
                                "where id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setupPreparedStatementAttributes(stmt, course);
            stmt.setObject(7, course.getId());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UnhandleException("Persistence update error", e);
        }
    }

    @Override
    public int deleteCourse(int id) {
        if (!isLegalCourseId(id))
            return -1;

        final String sql = "delete from course where id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UnhandleException("Persistence delete error", e);
        }
    }

    @Override
    public int deleteCourse(Course course) {
        if (!isLegalCourseId(course.getId()))
            return -1;

        final String sql = "delete from course where id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, course.getId());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UnhandleException("Persistence delete error", e);
        }
    }

    @Override
    public List<Course> getAllCourse() {
        final String sql = "select id, title, description, suitable_people, price, announcement, remark " +
                            "from course";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            return mapResultSetToList(stmt.executeQuery());
        } catch (SQLException e) {
            throw new UnhandleException("Persistence query error", e);
        }
    }

    @Override
    public Optional<Course> getCourseById(int id) {
        final String sql = "select id, title, description, suitable_people, price, announcement, remark " +
                "from course where id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            List<Course> courses = mapResultSetToList(stmt.executeQuery());
            return courses.size() > 0 ? Optional.of(courses.get(0)) : Optional.empty();
        } catch (SQLException e) {
            throw new UnhandleException("Persistence query with specific id error", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private boolean isLegalCourse(Course course) {
        String title = course.getTitle();
        return title != null && !title.isEmpty();
    }

    private boolean isLegalCourseId(Integer id) {
        return id != null && id > 0;
    }

    private void setupPreparedStatementAttributes(PreparedStatement preparedStatement, Course course) throws SQLException {
        preparedStatement.setObject(1, course.getTitle());
        preparedStatement.setObject(2, course.getDescription());
        preparedStatement.setObject(3, course.getSuitablePeople());
        preparedStatement.setObject(4, course.getPrice());
        preparedStatement.setObject(5, course.getAnnouncement());
        preparedStatement.setObject(6, course.getRemark());
    }

    private List<Course> mapResultSetToList(ResultSet result) throws SQLException {
        List<Course> courses = new ArrayList<>();
        while (result.next()) {
            Course course = new Course.Builder(result.getString("title"))
                    .id(getInteger(result, "id"))
                    .description(result.getString("description"))
                    .suitablePeople(result.getString("suitable_people"))
                    .price(getInteger(result, "price"))
                    .announcement(result.getString("announcement"))
                    .remark(result.getString("remark"))
                    .build();
            courses.add(course);
        }
        return  courses;
    }

    private Integer getInteger(ResultSet resultSet, String columnName) throws SQLException {
        int colnumValue = resultSet.getInt(columnName);
        return resultSet.wasNull() ? null : colnumValue;
    }
}
