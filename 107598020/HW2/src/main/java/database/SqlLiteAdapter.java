package database;

import com.google.inject.Inject;
import entity.Course;
import usecase.CourseDao;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class SqlLiteAdapter implements CourseDao {
    private final String url;

    @Inject
    public SqlLiteAdapter(Properties databaseProperties) {
        this.url = databaseProperties.getProperty("url");
    }

    public void createCourse(Course course) throws Exception {
        PreparedStatement pstmt = createInsertStatement(connectSqlLite(), course);
        pstmt.executeUpdate();
    }

    public List<Course> getAllCourses() throws Exception {
        String querySql = "SELECT * FROM course;";
        Connection conn = connectSqlLite();
        ResultSet rs = conn.createStatement().executeQuery(querySql);
        JsonMapper mapper = new JsonMapper();
        return mapper.mappingToCourse(rs);
    }

    public void deleteCourse(Course course) throws SQLException {
        String deleteSql = "DELETE FROM course WHERE id = " + course.getId();
        Connection conn = connectSqlLite();
        conn.createStatement().execute(deleteSql);
    }

    public void modifyCourse(Course course) throws SQLException {
        PreparedStatement pstmt = createUpdateStatement(connectSqlLite(), course);
        pstmt.executeUpdate();
    }

    private Connection connectSqlLite() throws SQLException {
        return DriverManager.getConnection(url);
    }

    private PreparedStatement createInsertStatement(Connection connectSqlLite, Course course) throws SQLException {
        String insertSql = "INSERT INTO course(name, description, targetcluster, price, coursenotice, notes) VALUES (?,?,?,?,?,?)";

        PreparedStatement pstmt = connectSqlLite.prepareStatement(insertSql);
        setEachAttributeExceptIDInStatement(pstmt, course);
        return pstmt;
    }

    private PreparedStatement createUpdateStatement(Connection connectSqlLite, Course course) throws SQLException {
        String updateSql = "Update course SET name = ? , " +
                                            "description = ? , " +
                                            "targetCluster = ? , " +
                                            "price = ? , " +
                                            "courseNotice = ? , " +
                                            "notes = ? " +
                                            "WHERE id = ?";
        PreparedStatement pstmt = connectSqlLite.prepareStatement(updateSql);
        setEachAttributeExceptIDInStatement(pstmt, course);
        pstmt.setInt(7, course.getId());
        return  pstmt;
    }

    private void setEachAttributeExceptIDInStatement(PreparedStatement pstmt, Course course) throws SQLException {
        pstmt.setString(1, course.getName());
        pstmt.setString(2, course.getDescription());
        pstmt.setString(3, course.getTargetCluster());
        pstmt.setInt(4, course.getPrice());
        pstmt.setString(5, course.getCourseNotice());
        pstmt.setString(6, course.getNotes());
    }
}
