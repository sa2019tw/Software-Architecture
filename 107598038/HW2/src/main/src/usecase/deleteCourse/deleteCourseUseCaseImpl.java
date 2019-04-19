package usecase.deleteCourse;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import input.deleteCourse.deleteCourseInput;
import model.Course;
import output.deleteCourseOutput;

public class deleteCourseUseCaseImpl implements deleteCourseUseCase {
    public deleteCourseUseCaseImpl() {
    }

    @Override
    public void execute(deleteCourseInput input, deleteCourseOutput output) {
        Course course = new Course();
        course.setID(input.getID());
        try {
            CourseDao courseDao = new ExcelCourseDao();
            courseDao.deleteCourse(course.getID());
        } catch (Exception e) {
            e.printStackTrace();
            output.getCourseError().reportError(e.getMessage());
        }
    }
}