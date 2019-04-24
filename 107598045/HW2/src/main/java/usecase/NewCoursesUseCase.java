package usecase;

import dao.CourseDao;
import model.Course;

import java.sql.SQLException;

public class NewCoursesUseCase {
    private CourseDao courseDao;

    public NewCoursesUseCase(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(CourseInput input, CourseOutput output){
        int courseId = 0;
        try {
            courseId = courseDao.getMaxCourseId();
            courseId++;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Course course = new Course(
                courseId,
                input.getCourseName(),
                input.getCourseDetail(),
                input.getCourseSuitPeople(),
                input.getCoursePrice(),
                input.getCourseNotes(),
                input.getCourseRemark()
        );

        try {
            courseDao.insertCourseToDB(course);
            output.setCourseId(courseId);
        } catch (SQLException e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
