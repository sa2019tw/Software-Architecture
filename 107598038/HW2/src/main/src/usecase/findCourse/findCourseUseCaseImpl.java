package usecase.findCourse;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import dto.CourseDto;
import input.findCourse.findCourseInput;
import model.Course;
import output.findCourseOutput;

public class findCourseUseCaseImpl implements findCourseUseCase {
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
    public void execute(findCourseInput input, findCourseOutput output) {
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
