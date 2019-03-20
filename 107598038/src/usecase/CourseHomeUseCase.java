package usecase;

import dao.CourseDao;
import dto.CourseDto;
import error.CourseError;
import model.Course;
import output.CourseOutput;

import java.util.ArrayList;
import java.util.List;

public class CourseHomeUseCase {

    public CourseHomeUseCase(CourseOutput output, CourseError error){
        List<CourseDto> dto = new ArrayList<>();

        CourseDao courseDao = null;
        try {
            courseDao = new CourseDao();
            List<Course> courseAll = courseDao.getCourseAll();

            for(Course course:courseAll){
                CourseDto cd = new CourseDto(
                        course.getID(),
                        course.getPrice(),
                        course.getNumberOfPeople(),
                        course.getName(),
                        course.getNote(),
                        course.getRemark(),
                        course.getSuitable(),
                        course.getDescription()
                );
                dto.add(cd);
            }

            output.setlist(dto);

        } catch (Exception e ){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
