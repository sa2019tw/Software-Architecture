package usecase;

import dao.CourseDaoInterface;
import model.Course;
import usecase.input.UseCaseInput;
import usecase.output.UseCaseOutput;

import java.sql.SQLException;

public class InsertCourseUseCase {
    CourseDaoInterface courseDao = null;

    public void setCourseDao(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(UseCaseInput useCaseInput, UseCaseOutput useCaseOutput) {
        Course course = new Course(
                useCaseInput.getId(),
                useCaseInput.getName(),
                useCaseInput.getContent(),
                useCaseInput.getMember(),
                useCaseInput.getPrice(),
                useCaseInput.getNotice(),
                useCaseInput.getRemark());
        try {
            courseDao.insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            useCaseOutput.reportError(e.getMessage());
        }
    }
}
