package usecase.CourseHome;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import dto.CourseDto;
import input.CouseHome.CourseHomeInput;
import model.Course;
import output.CourseHomeOutput;

import java.util.ArrayList;
import java.util.List;

public class CourseHomeUseCaseImpl implements CourseHomeUseCase {
    private  List<CourseDto> courseDto = new ArrayList<>();

    private void conversion(List<Course> courseAll) {
        for(Course course:courseAll) {
            CourseDto dto = new CourseDto(
                    course.getID(),
                    course.getPrice(),
                    course.getNumberOfPeople(),
                    course.getName(),
                    course.getNote(),
                    course.getRemark(),
                    course.getSuitable(),
                    course.getDescription()
            );
            courseDto.add(dto);
        }
    }

    @Override
    public void execute(CourseHomeInput input, CourseHomeOutput output) {
        CourseDao courseDao = null;
        try {
            courseDao = new ExcelCourseDao();
            List<Course> courseAll = courseDao.getCourseAll();
            conversion(courseAll);

            output.setCourse(courseDto);
        } catch (Exception e ){
            e.printStackTrace();
            output.getCourseError().reportError(e.getMessage());
        }

    }
}
