package Dao;

import Entity.Course;

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
                Course c = new Course(course.getCourseName(), course.getCourseDescription(), course.getCourseTarget(), course.getCoursePrice(), course.getCourseAttention(), course.getCourseRemark());
                courses.set(courses.indexOf(temp_course), c);
            }
        }
    }

    public void deleteCourse(String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)) {
                courses.remove(i);
            }
        }
    }
}
