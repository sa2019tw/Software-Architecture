package Dao;
import main.Course;

import java.util.List;

public interface ICourseDao {

    void addCourse(Course course);

    Course retrieveOneCourse(String courseName);

    List<Course> retrieveAllCourse();

    void updateCourse(Course course);

    void deleteCourse(String courseName);
}
