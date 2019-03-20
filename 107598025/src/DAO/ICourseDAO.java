package DAO;
import main.Course;

import java.util.List;

public interface ICourseDAO {

    void addCourse(Course course);

    Course retrieveOneCourse(String courseName);

    List<Course> retrieveAllCourse();

    void updateCourse(Course course);

    void deleteCourse(String courseName);
}
