package usecase;

import dao.CourseDao;
import input.CourseInput;
import model.Course;
import error.CourseError;

public class deleteCourseUseCase {
    public deleteCourseUseCase(CourseInput input, CourseError error){
        Course course = new Course();
        course.setID(input.getID());
        try {
            CourseDao courseDao = new CourseDao();
            courseDao.deleteCourse(course.getID());
        } catch (Exception e) {
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}