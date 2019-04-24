package Dao;
import Entity.Course;

import java.util.List;

public interface ICourseDao {

    boolean addCourse(Course course);

    Course retrieveOneCourse(Course course);

    List<Course> retrieveAllCourse();

    void updateCourse(Course course);

    void deleteCourse(Course course);
}
