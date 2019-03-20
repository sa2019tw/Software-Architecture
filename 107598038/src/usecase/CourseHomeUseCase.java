package usecase;

import dao.CourseDao;
import error.CourseError;
import model.Course;
import output.CourseOutput;

import java.util.List;

public class CourseHomeUseCase {

    public CourseHomeUseCase(CourseOutput output, CourseError error){


        CourseDao courseDao = null;
        try {
            courseDao = new CourseDao();
            List<Course> courseAll = courseDao.getCourseAll();
            output.setlist(courseAll);

        } catch (Exception e ){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
