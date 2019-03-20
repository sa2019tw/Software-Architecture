package usecase;

import dao.CourseDao;
import error.CourseError;
import input.CourseInput;
import model.Course;
import output.CourseOutput;

import java.util.List;

public class editCourseUseCase {
    public editCourseUseCase(int ID,CourseOutput output, CourseError error){
        CourseDao courseDao = null;
        try {
            courseDao = new CourseDao();
            Course course = courseDao.selectCourse(ID);
            output.setCourse(course);

        } catch (Exception e ){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }

    public editCourseUseCase(CourseInput input, CourseError error){
        Course course = new Course(
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
            CourseDao courseDao = new CourseDao();
            courseDao.updateCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
