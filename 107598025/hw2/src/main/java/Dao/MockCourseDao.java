package Dao;

import Entity.Course;

import java.util.ArrayList;
import java.util.List;

public class MockCourseDao implements ICourseDao {

    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        courses.add(course);
        return courses.size() > 0;
    }

    public Course retrieveOneCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(course.getCourseName())) {
                return courses.get(i);
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

    public void deleteCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(course.getCourseName())) {
                courses.remove(i);
            }
        }
    }
}
