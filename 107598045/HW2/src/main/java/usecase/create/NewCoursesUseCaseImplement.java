package usecase.create;

import dao.CourseDao;
import model.Course;
import usecase.create.input.CreateInput;
import usecase.create.output.CreateOutput;

import java.sql.SQLException;

public class NewCoursesUseCaseImplement implements NewCoursesUseCase {
    private CourseDao courseDao;

    public NewCoursesUseCaseImplement(){}

    public void setRepository(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void execute(CreateInput input, CreateOutput output){
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
