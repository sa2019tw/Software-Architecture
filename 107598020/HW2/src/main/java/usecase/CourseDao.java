package usecase;

import entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses() throws Exception;

    void deleteCourse(Course course) throws Exception;

    void modifyCourse(Course course) throws Exception;

    void createCourse(Course course) throws Exception;
}
