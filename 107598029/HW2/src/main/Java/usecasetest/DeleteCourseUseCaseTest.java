package usecasetest;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDao;
import usecase.io.CreatUseCaseIO.CreatUseCaseError;
import usecase.io.CreatUseCaseIO.CreatUseCaseErrorInterface;
import usecase.io.CreatUseCaseIO.CreatUseCaseInput;
import model.Course;
import org.junit.Before;
import usecase.CreateCourseUseCase;
import usecase.DeleteCourseUseCase;
import usecase.io.CreatUseCaseIO.CreatUseCaseInputInterface;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseError;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseErrorInterface;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseInput;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseInputInterface;

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
        CreatUseCaseInputInterface creatUseCaseInput = new CreatUseCaseInput(
                1,
                "CleanArchitercture",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        CreatUseCaseErrorInterface creatUseCaseError = new CreatUseCaseError();
        createCourseUseCase.creat(creatUseCaseInput, creatUseCaseError);
        Course actual = dao.getcourseinfo(1);
        assertEquals("CleanArchitercture", actual.getName());

        creatUseCaseInput = new CreatUseCaseInput(
                2,
                "C2",
                "大二",
                1000,
                "A",
                "",
                "remark"
        );
        createCourseUseCase.creat(creatUseCaseInput, creatUseCaseError);
        actual = dao.getcourseinfo(2);
        assertEquals("C2", actual.getName());

        DeleteUseCaseInputInterface deleteUseCaseInputInterface = new DeleteUseCaseInput(
                2,
                "C2",
                "大二",
                1000,
                "A",
                "",
                "remark"
        );

        DeleteUseCaseErrorInterface deleteUseCaseErrorInterface = new DeleteUseCaseError();

        deleteCourseUseCase.deleteCourse(deleteUseCaseInputInterface, deleteUseCaseErrorInterface);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void DeleteCourseUseCaseTestNullPointerException() throws SQLException {
        CreatUseCaseInputInterface creatUseCaseInputInterface = new CreatUseCaseInput(
                1,
                "CleanArchitercture",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        CreatUseCaseErrorInterface creatUseCaseErrorInterface = new CreatUseCaseError();
        createCourseUseCase.creat(creatUseCaseInputInterface, creatUseCaseErrorInterface);
        Course actual = dao.getcourseinfo(1);
        assertEquals("CleanArchitercture", actual.getName());

        creatUseCaseInputInterface = new CreatUseCaseInput(
                2,
                "C2",
                "大二",
                1000,
                "A",
                "",
                "remark"
        );
        createCourseUseCase.creat(creatUseCaseInputInterface, creatUseCaseErrorInterface);
        actual = dao.getcourseinfo(2);
        assertEquals("C2", actual.getName());

        DeleteUseCaseInputInterface deleteUseCaseInputInterface = new DeleteUseCaseInput(
                2,
                "C2",
                "大二",
                1000,
                "A",
                "",
                "remark"
        );

        DeleteUseCaseErrorInterface deleteUseCaseErrorInterface = new DeleteUseCaseError();

        deleteCourseUseCase.deleteCourse(deleteUseCaseInputInterface, deleteUseCaseErrorInterface);
        if(!deleteUseCaseErrorInterface.hasError()){
            dao.getcourseinfo(2);
        }
    }

}