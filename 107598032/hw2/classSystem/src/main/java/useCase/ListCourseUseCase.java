package useCase;

import dao.CourseDaoInterface;

import java.sql.SQLException;

public class ListCourseUseCase {
    CourseDaoInterface courseDao = null;

    public void setCourseDao(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(UseCaseInput useCaseInput, UseCaseOutput useCaseOutput) {
        try {
            useCaseOutput.setCourses(courseDao.getCourseList());
        } catch (SQLException e) {
            e.printStackTrace();
            useCaseOutput.reportError(e.getMessage());
        }
    }
}
