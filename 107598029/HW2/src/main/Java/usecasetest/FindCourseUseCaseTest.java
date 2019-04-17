package usecasetest;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDao;
import io.UseCaseError;
import io.UseCaseInput;
import io.UseCaseOutput;
import model.Course;
import org.junit.After;
import org.junit.Before;
import usecase.CreateCourseUseCase;
import usecase.FindCourseUseCase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindCourseUseCaseTest {
    private CreateCourseUseCase createCourseUseCase;
    private FindCourseUseCase findCourseUseCase;
    private CourseDaoInterface dao;
    @Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        createCourseUseCase = new CreateCourseUseCase(dao);
        findCourseUseCase = new FindCourseUseCase(dao);
    }

    @org.junit.Test
    public void FindCourseUseCaseTest() throws SQLException {
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
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        createCourseUseCase.creat(useCaseInput, useCaseError);
        System.out.println(useCaseInput.getCoursename());
        actual = dao.getcourseinfo(2);
        assertEquals("C2", actual.getName());

        List<UseCaseOutput> useCaseOutput = new ArrayList<>();
        findCourseUseCase.find(useCaseInput, useCaseOutput, useCaseError);
        assertEquals(1, useCaseOutput.size());
    }
}