package mock;

import main.Course;
import Dao.ICourseDao;

import java.util.ArrayList;
import java.util.List;

public class MockCourseDao implements ICourseDao {

    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course retrieveOneCourse(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }

    public List<Course> retrieveAllCourse() {
        return courses;
    }

    public void updateCourse(Course course) {
        for (Course temp_course : courses) {
            if (temp_course.getCourseName().equals(course.getCourseName())) {
                temp_course.setCourseDescription(course.getCourseDescription());
                temp_course.setCourseTarget(course.getCourseTarget());
                temp_course.setCoursePrice(course.getCoursePrice());
                temp_course.setCourseAttention(course.getCourseAttention());
                temp_course.setCourseRemark(course.getCourseRemark());
            }
        }
    }

    public void deleteCourse(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                courses.remove(course);
            }
        }
    }

}
