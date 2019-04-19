package entity.dao;

import entity.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseDao {
    int addCourse(Course course);
    int updateCourse(Course course);
    int deleteCourse(int id);
    List<Course> getAllCourses();
    Optional<Course> getCourseById(int id);
}
