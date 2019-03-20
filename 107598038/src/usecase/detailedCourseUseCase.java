package usecase;

import dao.CourseDao;
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
            output.setCourse(course);

        } catch (Exception e ){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
