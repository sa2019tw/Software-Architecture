package dao;

import model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDaoInterface {
    List<Course> getCourseList() throws Exception;
    void insertCourse(Course course) throws Exception;
    void deleteCourse(int id) throws Exception;
    void updateCourse(Course course) throws Exception;
    Course getCourseById(int id) throws Exception;
}
