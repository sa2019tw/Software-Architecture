package usecasetest;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDao;
import usecase.io.CreatUseCaseIO.CreatUseCaseError;
import usecase.io.CreatUseCaseIO.CreatUseCaseInput;
import model.Course;
import usecase.CreateCourseUseCase;

import java.sql.SQLException;

import static org.junit.Assert.*;
public class CreateCourseUseCaseTest {
    private CreateCourseUseCase createCourseUseCase;
    private CourseDaoInterface dao;

    @org.junit.Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        createCourseUseCase = new CreateCourseUseCase(dao);
    }

    @org.junit.Test
    public void CreateCourseUseCaseTest() throws SQLException {
        CreatUseCaseInput creatUseCaseInput = new CreatUseCaseInput(
                1,
                "CleanArchitercture",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        CreatUseCaseError creatUseCaseError = new CreatUseCaseError();
        createCourseUseCase.creat(creatUseCaseInput, creatUseCaseError);
        Course actual = dao.getcourseinfo(1);
        assertEquals("CleanArchitercture", actual.getName());
    }
}