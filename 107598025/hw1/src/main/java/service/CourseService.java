package service;

import DAO.ICourseDAO;
import Entity.Course;

import java.util.List;


public class CourseService implements ICourseService {

    private ICourseDAO courseDAO;

    public CourseService(ICourseDAO courseDAO) {

        this.courseDAO = courseDAO;
    }

    public void addCourse(Course course) {

        courseDAO.addCourse(course);
    }

    public Course retrieveOneCourse(String courseName) {
        return courseDAO.retrieveOneCourse(courseName);
    }

    public List<Course> retrieveAllCourse() {

        return courseDAO.retrieveAllCourse();
    }

    public void updateCourse(Course course) {

        courseDAO.updateCourse(course);
    }

    public void deleteCourse(String courseName) {

        courseDAO.deleteCourse(courseName);
    }
}
