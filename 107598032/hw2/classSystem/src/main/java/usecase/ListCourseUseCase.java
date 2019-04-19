package usecase;

import dao.CourseDaoInterface;
import usecase.input.UseCaseInput;
import usecase.output.UseCaseOutput;

import java.sql.SQLException;

public class ListCourseUseCase {
    CourseDaoInterface courseDao = null;

    public void setCourseDao(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(UseCaseInput useCaseInput, UseCaseOutput useCaseOutput) {
        try {
            useCaseOutput.setCourses(courseDao.getCourseList());
        } catch (Exception e) {
            e.printStackTrace();
            useCaseOutput.reportError(e.getMessage());
        }
    }
}
