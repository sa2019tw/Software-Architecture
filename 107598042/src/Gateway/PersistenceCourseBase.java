package Gateway;

import Domain.Course;
import Domain.CourseBase;

import java.util.ArrayList;
import java.sql.*;


public class PersistenceCourseBase implements CourseBase {

    private final String dbUrl = "jdbc:mysql://localhost:3306/CourseDemo";
    private final String account = "root";
    private final String password = "root";
    private Connection connection;
    private final String tableName = "Course";

    public PersistenceCourseBase() {

    }

    void connectionToDatabase() {
        try {
            connection = DriverManager.getConnection(dbUrl, account, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void closeConnectionToDatabase() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeCreateCourseStatement(Course course) {
        try {
            int identity = this.generatorIdentityFromGivenTable(tableName);
            course.setId(identity);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `Course` (`courseName`, `description`, `remark`, `price`, `id`, `suitableObject`, `Notes`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, course.getCourseName());
            statement.setString(2, course.getDescription());
            statement.setString(3, course.getRemark());
            statement.setInt(4, (int)course.getPrice());
            statement.setInt(5, identity);
            statement.setString(6, course.getSuitableObject());
            statement.setString(7, course.getNotes());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createNewCourse(Course course) {
        connectionToDatabase();

        executeCreateCourseStatement(course);

        closeConnectionToDatabase();
    }

    private Course executeFetchCourseStatement(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from `Course` where `id` = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (isResultSetEmpty(result))
                return null;

            Course course = doLoad(result);
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Course fetchCourseById(int id) {
        connectionToDatabase();

        Course Course = executeFetchCourseStatement(id);

        closeConnectionToDatabase();

        return Course;
    }

    Course doLoad(ResultSet result) throws SQLException {
        Course course = Course.createCourse(result.getString("courseName"));
        course.setId(result.getInt("id"));
        course.setPrice(result.getInt("price"));
        course.setDescription(result.getString("description"));
        course.setRemark(result.getString("remark"));
        course.setSuitableObject(result.getString("suitableObject"));
        course.setNotes(result.getString("Notes"));
        return course;
    }

    private boolean isResultSetEmpty(ResultSet result) throws SQLException {
        return !result.next();
    }

    private ArrayList<Course> executeFetchAllCourseStatement() {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from course");
            ResultSet result = statement.executeQuery();
            ArrayList<Course> arrayList = new ArrayList<Course>();
            while (result.next()) {
                Course course = doLoad(result);
                arrayList.add(course);
            }
            return arrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Course> fetchAllCourse() {
        connectionToDatabase();
        ArrayList<Course> arrayList = executeFetchAllCourseStatement();
        closeConnectionToDatabase();
        return arrayList;
    }

    private void executeModifyStatement(int id, Course course) {
        try {
            PreparedStatement statement = connection.prepareStatement("update course set `coursename` = ?, `description` = ?, `remark` = ?, `price` = ?, `suitableObject` = ?, `Notes` = ? where `id` = ?;");
            statement.setString(1, course.getCourseName());
            statement.setString(2, course.getDescription());
            statement.setString(3, course.getRemark());
            statement.setInt(4, (int)course.getPrice());
            statement.setString(5, course.getSuitableObject());
            statement.setString(6, course.getNotes());
            statement.setInt(7, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyExistCourseById(int id, Course course) {
        connectionToDatabase();

        executeModifyStatement(id, course);

        closeConnectionToDatabase();
    }

    void executeDeleteCourseStatement(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from course where id = ?");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourseById(int id) {
        connectionToDatabase();
        executeDeleteCourseStatement(id);
        closeConnectionToDatabase();
    }


    private int generatorIdentityFromGivenTable(String tableName) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'coursedemo' AND   TABLE_NAME   = ?;");
            statement.setString(1, tableName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("AUTO_INCREMENT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -100;
    }

    private void executeCleanCourseTableStatement() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("Delete from Course");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearCourseTable() {
        connectionToDatabase();
        executeCleanCourseTableStatement();
        closeConnectionToDatabase();
    }
}
