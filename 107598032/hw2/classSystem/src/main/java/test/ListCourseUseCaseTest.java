package test;

import dao.InMemoryCourseDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import useCase.InsertCourseUseCase;
import useCase.ListCourseUseCase;
import useCase.UseCaseInput;
import useCase.UseCaseOutput;

import static org.junit.Assert.assertEquals;

public class ListCourseUseCaseTest {
    InMemoryCourseDaoImpl inMemoryCourseDao;
    @Before
    public void setUp() throws Exception{
        inMemoryCourseDao = new InMemoryCourseDaoImpl();
        InsertCourseUseCase insertCourseUseCase = new InsertCourseUseCase();
        insertCourseUseCase.setCourseDao(inMemoryCourseDao);
        UseCaseInput useCaseInput = new UseCaseInput(
                0,
                "軟體架構",
                "clean architecture",
                "碩一",
                80000,
                "先修POSD、OOAD",
                "不要遲到"
        );
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        insertCourseUseCase.execute(useCaseInput, useCaseOutput);
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void listCourseTest(){
        ListCourseUseCase listCourseUseCase = new ListCourseUseCase();
        listCourseUseCase.setCourseDao(inMemoryCourseDao);
        UseCaseInput useCaseInput = new UseCaseInput(
                -1,
                "",
                "",
                "",
                -1,
                "",
                ""
        );
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        listCourseUseCase.execute(useCaseInput, useCaseOutput);
        assertEquals(1, useCaseOutput.getCourses().size());
    }
}
