package usecase.editCourse;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import error.CourseError;
import input.editCourse.editCourseInput;
import model.Course;
import output.editCourseOutput;

public class editCourseUseCaseImpl implements editCourseUseCase{
    public editCourseUseCaseImpl(){ }

    @Override
    public void execute(editCourseInput input, editCourseOutput output) {
        Course course = new Course(
                0,
                input.getPrice(),
                input.getNumberOfPeople(),
                input.getName(),
                input.getNote(),
                input.getRemark(),
                input.getSuitable(),
                input.getDescription()
        );
        course.setID(input.getID());

        try {
            CourseDao courseDao = new ExcelCourseDao();
            courseDao.updateCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            output.getCourseError().reportError(e.getMessage());
        }
    }
}
