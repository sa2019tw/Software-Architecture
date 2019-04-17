package usecase.addCourse;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import input.addCourse.addCourseInput;
import model.Course;
import output.addCourseOutput;

public class addCourseUseCaseImpl implements addCourseUseCase{
    public addCourseUseCaseImpl(){}

    @Override
    public void execute(addCourseInput input, addCourseOutput output) {
        Course course = new Course(
                input.getPrice(),
                input.getNumberOfPeople(),
                input.getName(),
                input.getNote(),
                input.getRemark(),
                input.getSuitable(),
                input.getDescription()
        );
        try {
            CourseDao courseDao = new ExcelCourseDao();
            courseDao.insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            output.getCourseError().reportError(e.getMessage());
        }
    }
}
