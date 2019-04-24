package usecase_test;

import dao.CourseDao;
import dao.impl.InMemoryCourseDao;
import model.Course;
import org.junit.Test;
import usecase.create.NewCoursesUseCase;
import usecase.create.NewCoursesUseCaseImplement;
import usecase.create.input.CreateInput;
import usecase.create.input.CreateInputImplement;
import usecase.create.output.CreateOutput;
import usecase.create.output.CreateOutputImplement;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class NewCoursesUseCaseTest {
    private NewCoursesUseCase useCase;
    private CourseDao dao;

    @org.junit.Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        useCase = new NewCoursesUseCaseImplement();
    }

    @Test
    public void insertCourseUseCase(){
        CreateInput input = new CreateInputImplement(
                "clean architecture",
                "detail",
                "people",
                81000,
                "note",
                "remark"
        );
        CreateOutput output = new CreateOutputImplement();

        useCase.setRepository(dao);
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