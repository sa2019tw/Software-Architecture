package usecasetest;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDao;
import usecase.io.CreatUseCaseIO.*;
import model.Course;
import org.junit.Before;
import usecase.CreateCourseUseCase;
import usecase.ReadAllCourseUseCase;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseError;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseErrorInterface;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseOutput;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseOutputInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadAllCourseUseCaseTest {
    private CreateCourseUseCase createCourseUseCase;
    private ReadAllCourseUseCase readAllCourseUseCase;
    private CourseDaoInterface dao;
    @Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        createCourseUseCase = new CreateCourseUseCase(dao);
        readAllCourseUseCase = new ReadAllCourseUseCase(dao);
    }

    @org.junit.Test
    public void ReadAllCourseUseCaseTest() throws SQLException {
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
                1,
                "C1",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        createCourseUseCase.creat(creatUseCaseInputInterface, creatUseCaseErrorInterface);

        ReadAllUseCaseOutputInterface readAllUseCaseOutputInterfaces = new ReadAllUseCaseOutput();
        ReadAllUseCaseErrorInterface readAllUseCaseErrorInterface = new ReadAllUseCaseError();
        readAllCourseUseCase.ReadAllCourse(readAllUseCaseOutputInterfaces, readAllUseCaseErrorInterface);
        assertEquals(2, readAllUseCaseOutputInterfaces.getCourseDto().size());
    }
}