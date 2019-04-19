package usecase_test;

import dao.CourseDao;
import dao.impl.InMemoryCourseDao;
import model.Course;
import org.junit.Test;
import usecase.CourseInput;
import usecase.CourseOutput;
import usecase.NewCoursesUseCase;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class NewCoursesUseCaseTest {
    private NewCoursesUseCase useCase;
    private CourseDao dao;

    @org.junit.Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        useCase = new NewCoursesUseCase(dao);
    }

    @Test
    public void insertCourseUseCase(){
        CourseInput input = new CourseInput(
                "clean architecture",
                "detail",
                "people",
                81000,
                "note",
                "remark"
        );
        CourseOutput output = new CourseOutput();

        useCase.execute(input, output);
        Course actual = null;

        try {
            actual = dao.findTheCourse(output.getCourseId());

            assertEquals(input.getCourseName(), actual.getCourseName());
            assertEquals(1, dao.getCourseList().size());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}