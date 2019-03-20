package usecase;

import dao.CourseDao;
import dto.CourseDto;
import error.CourseError;
import model.Course;
import output.CourseOutput;


import java.util.List;

public class detailedCourseUseCase {
    public detailedCourseUseCase(int ID,CourseOutput output, CourseError error){
        CourseDao courseDao = null;
        try {
            courseDao = new CourseDao();
            Course course = courseDao.selectCourse(ID);

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


            output.setCourse(dto);

        } catch (Exception e ){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
