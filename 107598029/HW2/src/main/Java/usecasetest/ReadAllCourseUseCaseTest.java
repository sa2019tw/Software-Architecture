package usecasetest;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDao;
import io.UseCaseError;
import io.UseCaseInput;
import io.UseCaseOutput;
import model.Course;
import org.junit.Before;
import usecase.CreateCourseUseCase;
import usecase.ReadAllCourseUseCase;

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
                1,
                "C1",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        createCourseUseCase.creat(useCaseInput, useCaseError);

        List<UseCaseOutput> useCaseOutput = new ArrayList<>();
        readAllCourseUseCase.ReadAllCourse(useCaseOutput, useCaseError);
        assertEquals(2, useCaseOutput.size());
    }
}