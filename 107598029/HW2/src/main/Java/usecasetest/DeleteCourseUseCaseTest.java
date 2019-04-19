package usecasetest;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDao;
import io.UseCaseError;
import io.UseCaseInput;
import model.Course;
import org.junit.Before;
import usecase.CreateCourseUseCase;
import usecase.DeleteCourseUseCase;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DeleteCourseUseCaseTest {
    private CreateCourseUseCase createCourseUseCase;
    private DeleteCourseUseCase deleteCourseUseCase;
    private CourseDaoInterface dao;

    @Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        createCourseUseCase = new CreateCourseUseCase(dao);
        deleteCourseUseCase = new DeleteCourseUseCase(dao);
    }


    @org.junit.Test
    public void DeleteCourseUseCaseTest() throws SQLException {
        UseCaseInput useCaseInput = new UseCaseInput(
                1,
                "CleanArchitercture",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        UseCaseError useCaseError = new UseCaseError();
        createCourseUseCase.creat(useCaseInput, useCaseError);
        Course actual = dao.getcourseinfo(1);
        assertEquals("CleanArchitercture", actual.getName());

        useCaseInput = new UseCaseInput(
                2,
                "C2",
                "大二",
                1000,
                "A",
                "",
                "remark"
        );
        createCourseUseCase.creat(useCaseInput, useCaseError);
        actual = dao.getcourseinfo(2);
        assertEquals("C2", actual.getName());

        deleteCourseUseCase.deleteCourse(useCaseInput, useCaseError);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void DeleteCourseUseCaseTestNullPointerException() throws SQLException {
        UseCaseInput useCaseInput = new UseCaseInput(
                1,
                "CleanArchitercture",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        UseCaseError useCaseError = new UseCaseError();
        createCourseUseCase.creat(useCaseInput, useCaseError);
        Course actual = dao.getcourseinfo(1);
        assertEquals("CleanArchitercture", actual.getName());

        useCaseInput = new UseCaseInput(
                2,
                "C2",
                "大二",
                1000,
                "A",
                "",
                "remark"
        );
        createCourseUseCase.creat(useCaseInput, useCaseError);
        actual = dao.getcourseinfo(2);
        assertEquals("C2", actual.getName());

        deleteCourseUseCase.deleteCourse(useCaseInput, useCaseError);
        if(!useCaseError.hasError()){
            dao.getcourseinfo(2);
        }
    }

}