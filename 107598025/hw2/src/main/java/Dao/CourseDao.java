package Dao;

import Entity.Course;
import connectivity.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements ICourseDao {

    private DBConnector dbConnector = new DBConnector();;
    private Connection connection;

    private void connectToDatabase() {
        connection = dbConnector.getConnection();
    }

    private void closeDatabase() {
        dbConnector.closeConnection();
    }

    public boolean addCourse(Course course) {
        connectToDatabase();
        try {
            String sql = "INSERT INTO course VALUES ('" + course.getCourseName() + "', '" + course.getCourseDescription() + "', '" + course.getCourseTarget() + "', " + course.getCoursePrice() + ", '" + course.getCourseAttention() + "', '" + course.getCourseRemark() + "')";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Added");
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            closeDatabase();
        }
        return true;
    }

    public Course retrieveOneCourse(String courseName) {
        connectToDatabase();
        String sql = "SELECT * FROM course WHERE course_name_PK = '" + courseName + "'";
        System.out.println(sql);
        Statement statement;
        Course courseTemp = new Course();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                courseTemp = getData(resultSet);
            }
        } catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            closeDatabase();
        }
        System.out.println("Retrieved one");
        return courseTemp;
    }

    public List<Course> retrieveAllCourse() {
        connectToDatabase();
        String sql = "SELECT * FROM course";
        System.out.println(sql);
        Statement statement;
        List<Course> courseList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Course course = getData(resultSet);
                courseList.add(course);
                System.out.println("pushed");
            }
        } catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            closeDatabase();
        }

        System.out.println("Retrieved all");
        return courseList;
    }

    private Course getData(ResultSet resultSet) {
        connectToDatabase();
        Course course = new Course();
        try {
            course = new Course(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6));
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            closeDatabase();
        }
        return course;
    }

    public boolean updateCourse(Course course) {
        connectToDatabase();
        try {
            String sql = "UPDATE course SET course_name_PK = '" + course.getCourseName() + "', course_description = '" + course.getCourseDescription() + "', course_target = '" + course.getCourseTarget() + "', course_price = " + course.getCoursePrice() + ", course_attention = '" + course.getCourseAttention() + "', course_remark = '" + course.getCourseRemark() + "' WHERE course_name_PK = '" + course.getCourseName() + "'";
            System.out.println(sql);
            Statement statement= connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Updated");
            return true;
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            closeDatabase();
        }
        return false;
    }

    public boolean deleteCourse(String courseName) {
        connectToDatabase();
        try {
            String sql = "DELETE FROM course WHERE course_name_PK = '" + courseName + "'";
            System.out.println(sql);
            Statement statement= connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Deleted");
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            closeDatabase();
        }
        return true;
    }
}
