package useCase;

import dao.CourseDaoInterface;

import java.sql.SQLException;

public class DeleteCourseUseCase {
    CourseDaoInterface courseDao = null;

    public void setCourseDao(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(UseCaseInput useCaseInput, UseCaseOutput useCaseOutput) {
        try {
            courseDao.deleteCourse(useCaseInput.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            useCaseOutput.reportError(e.getMessage());
        }
    }
}
