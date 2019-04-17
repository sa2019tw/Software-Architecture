package service;

import entity.Course;
import entity.DaoFactory;
import entity.dao.ICourseDao;
import java.util.List;
import java.util.Optional;

public class CourseService {
    private ICourseDao courseDao;

    public CourseService() {
        DaoFactory factory = new DaoFactory();
        courseDao = factory.createCourseDao();
    }

    public boolean addCourse(Course course) {
        int result = courseDao.addCourse(course);
        return result > 0;
    }

    public Optional<Course> getCourseForUpdate(int id) {
        return courseDao.getCourseById(id);
    }

    public boolean updateCourse(Course course) {
        int result = courseDao.updateCourse(course);
        return result > 0;
    }

    public boolean deleteCourse(int id) {
        int result = courseDao.deleteCourse(id);
        return result > 0;
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }
}
