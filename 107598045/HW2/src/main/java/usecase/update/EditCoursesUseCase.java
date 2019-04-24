package usecase.update;

import dao.CourseDao;
import model.Course;
import usecase.CourseInput;
import usecase.CourseOutput;

import java.sql.SQLException;

public class EditCoursesUseCase {
    private CourseDao courseDao;
    
    public EditCoursesUseCase(CourseDao courseDao) {
        this.courseDao = courseDao;    
    }

    public void getTheCourse(CourseInput input, CourseOutput output) {
        try {
            output.setTheCourse(courseDao.findTheCourse(input.getCourseId()));
        } catch (SQLException e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }

    public void editTheCourseToDB(CourseInput input, CourseOutput output) {
        Course course = new Course(
                input.getCourseId(),
                input.getCourseName(),
                input.getCourseDetail(),
                input.getCourseSuitPeople(),
                input.getCoursePrice(),
                input.getCourseNotes(),
                input.getCourseRemark()
        );
        try {
            courseDao.editCourseToDB(course);
        } catch (SQLException e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
