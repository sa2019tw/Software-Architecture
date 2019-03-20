package useCase;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import model.Course;

import java.sql.SQLException;

public class InsertCourseUseCase {
    private CourseDao courseDao;
    public InsertCourseUseCase(){
        this.courseDao = new CourseDaoImpl();
    }

    public void insert(UseCaseInput useCaseInput, UseCaseOutput useCaseOutput){
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
        } catch (SQLException e) {
            e.printStackTrace();
            useCaseOutput.reportError(e.getMessage());
        }
    }
}
