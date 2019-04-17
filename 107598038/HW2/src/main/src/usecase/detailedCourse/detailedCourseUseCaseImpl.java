package usecase.detailedCourse;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import dto.CourseDto;
import input.detailedCourse.detailedCourseInput;
import model.Course;
import output.detailedCourseOutput;


public class detailedCourseUseCaseImpl implements detailedCourseUseCase {
    private CourseDto courseDto;

    private void conversion(Course course){
        courseDto = new CourseDto(
                course.getID(),
                course.getPrice(),
                course.getNumberOfPeople(),
                course.getName(),
                course.getNote(),
                course.getRemark(),
                course.getSuitable(),
                course.getDescription()
        );
    }

    @Override
    public void execute(detailedCourseInput input, detailedCourseOutput output) {
        CourseDao courseDao = null;
        try {
            courseDao = new ExcelCourseDao();
            Course course = courseDao.selectCourse(input.getID());
            conversion(course);
            output.setCourse(courseDto);

        } catch (Exception e ){
            e.printStackTrace();
            output.getCourseError().reportError(e.getMessage());
        }
    }
}
