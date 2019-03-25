package entity.dao;

import entity.Course;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CourseDao implements ICourseDao {
    private DataSource dataSource;

    public CourseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addCourse(Course course) {
        if (!isLegalCourse(course))
            return -1;

        final String sql = "insert into course (title, description, suitable_people, price, announcement, remark)" +
                           "values (?, ?, ?, ?, ?, ?)";
        int result = executeUpdateStatement((Connection connection) -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                setupPreparedStatementAttributes(preparedStatement, course);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return preparedStatement;
        });
        return result;
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
        int result = executeUpdateStatement((Connection connection) -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                setupPreparedStatementAttributes(preparedStatement, course);
                preparedStatement.setObject(7, course.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return preparedStatement;
        });
        return result;
    }

    @Override
    public int deleteCourse(int id) {
        if (!isLegalCourseId(id))
            return -1;

        final String sql = "delete from course where id=?";
        int result = executeUpdateStatement((Connection connection) -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setObject(1, id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return preparedStatement;
        });
        return result;
    }

    @Override
    public List<Course> getAllCourses() {
        final String sql = "select id, title, description, suitable_people, price, announcement, remark " +
                            "from course";
        List<Course> courses = executeQueryStatement((Connection connection) -> {
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return preparedStatement;
            });

        return courses;
    }

    @Override
    public Optional<Course> getCourseById(int id) {
        final String sql = "select id, title, description, suitable_people, price, announcement, remark " +
                "from course where id=?";
        List<Course> courses = executeQueryStatement((Connection connection) -> {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return preparedStatement;
        });
        return courses.size() > 0 ? Optional.of(courses.get(0)) : Optional.empty();
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

    private List<Course> executeQueryStatement(Function<Connection, PreparedStatement> setupStatement) {
        List<Course> courses = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = getConnection();
            preparedStatement = setupStatement.apply(conn);

            ResultSet result = preparedStatement.executeQuery();
            courses = mapResultSetToList(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courses;
    }

    private int executeUpdateStatement(Function<Connection, PreparedStatement> setupStatement) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int result = -1;
        try {
            conn = getConnection();
            preparedStatement = setupStatement.apply(conn);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private List<Course> mapResultSetToList(ResultSet result) throws SQLException {
        List<Course> courses = new ArrayList<>();
        while (result.next()) {
            Course course = new Course();
            course.setId(getInteger(result, "id"));
            course.setTitle(result.getString("title"));
            course.setDescription(result.getString("description"));
            course.setSuitablePeople(result.getString("suitable_people"));
            course.setPrice(getInteger(result, "price"));
            course.setAnnouncement(result.getString("announcement"));
            course.setRemark(result.getString("remark"));
            courses.add(course);
        }
        return  courses;
    }

    private Integer getInteger(ResultSet resultSet, String columnName) throws SQLException {
        int value = resultSet.getInt(columnName);
        return resultSet.wasNull() ? null : value;
    }
}
