package core.boundary.require;

import core.entity.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseRepository {
    int addCourse(Course course);
    int updateCourse(Course course);
    int deleteCourse(int id);
    int deleteCourse(Course course);
    List<Course> getAllCourse();
    Optional<Course> getCourseById(int id);
}
