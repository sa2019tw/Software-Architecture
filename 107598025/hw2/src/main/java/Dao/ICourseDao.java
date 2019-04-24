package Dao;
import Entity.Course;

import java.util.List;

public interface ICourseDao {

    boolean addCourse(Course course);

    Course retrieveOneCourse(String courseName);

    List<Course> retrieveAllCourse();

    boolean updateCourse(Course course);

    boolean deleteCourse(String courseName);
}
