package usecase;

import dao.CourseDao;
import input.CourseInput;
import model.Course;
import error.CourseError;

public class addCourseUseCase {
    public addCourseUseCase(CourseInput input, CourseError error){
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
            CourseDao courseDao = new CourseDao();
            courseDao.insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
