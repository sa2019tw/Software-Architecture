package Domain;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseBase {
    void createNewCourse(Course course);
    Course fetchCourseById(int id);
    ArrayList<Course> fetchAllCourse();
    void modifyExistCourseById(int id, Course course);
    void deleteCourseById(int id);
}
