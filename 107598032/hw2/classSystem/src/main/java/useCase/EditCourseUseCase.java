package useCase;

import dao.CourseDaoInterface;
import model.Course;

import java.sql.SQLException;

public class EditCourseUseCase {
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
            courseDao.updateCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
            useCaseOutput.reportError(e.getMessage());
        }
    }
}
