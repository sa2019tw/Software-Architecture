package dao;

import model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    List<Course> getCourseAll() throws SQLException;
    Course selectCourse(int ID) throws SQLException;
    void insertCourse(Course course) throws SQLException;
    void deleteCourse(int ID) throws SQLException;
    void updateCourse(Course course) throws SQLException;
}
