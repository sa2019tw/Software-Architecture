package Dao;

import Entity.Course;

import java.util.ArrayList;
import java.util.List;

public class MockCourseDao implements ICourseDao {

    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        try {
            courses.add(course);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("added");
        return true;
    }

    public Course retrieveOneCourse(String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)) {
                return courses.get(i);
            }
        }
        return null;
    }

    public List<Course> retrieveAllCourse() {
        return courses;
    }

    public boolean updateCourse(Course course) {
        for (Course temp_course : courses) {
            if (temp_course.getCourseName().equals(course.getCourseName())) {
                Course c = new Course(course.getCourseName(), course.getCourseDescription(), course.getCourseTarget(), course.getCoursePrice(), course.getCourseAttention(), course.getCourseRemark());
                courses.set(courses.indexOf(temp_course), c);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
}
