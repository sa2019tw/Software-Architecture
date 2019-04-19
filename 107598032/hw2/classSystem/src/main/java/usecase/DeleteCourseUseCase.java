package usecase;

import dao.CourseDaoInterface;
import usecase.input.UseCaseInput;
import usecase.output.UseCaseOutput;

import java.sql.SQLException;

public class DeleteCourseUseCase {
    CourseDaoInterface courseDao = null;

    public void setCourseDao(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(UseCaseInput useCaseInput, UseCaseOutput useCaseOutput) {
        try {
            courseDao.deleteCourse(useCaseInput.getId());
        } catch (Exception e) {
            e.printStackTrace();
            useCaseOutput.reportError(e.getMessage());
        }
    }
}
