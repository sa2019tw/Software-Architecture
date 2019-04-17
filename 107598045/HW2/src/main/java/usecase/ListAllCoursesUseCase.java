package usecase;

import dao.CourseDao;
import model.Course;

import java.sql.SQLException;
import java.util.List;

public class ListAllCoursesUseCase {
    private CourseDao courseDao;

    public ListAllCoursesUseCase(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(CourseInput input, CourseOutput output) {
        try {
            List<Course> courseList = courseDao.getCourseList();
            output.setCourseList(courseList);
        } catch (SQLException e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
