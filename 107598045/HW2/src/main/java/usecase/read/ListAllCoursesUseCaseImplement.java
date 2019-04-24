package usecase.read;

import dao.CourseDao;
import model.Course;
import usecase.read.input.ListAllInput;
import usecase.read.output.ListAllOutput;

import java.sql.SQLException;
import java.util.List;

public class ListAllCoursesUseCaseImplement implements ListAllCoursesUseCase{
    private CourseDao courseDao;

    public ListAllCoursesUseCaseImplement(){}

    @Override
    public void setRepository(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void execute(ListAllInput input, ListAllOutput output) {
        try {
            List<Course> courseList = courseDao.getCourseList();
            output.setCourseList(courseList);
        } catch (SQLException e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
