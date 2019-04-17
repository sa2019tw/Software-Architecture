package test;

import dao.InMemoryCourseDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import useCase.InsertCourseUseCase;
import useCase.UseCaseInput;
import useCase.UseCaseOutput;
import static org.junit.Assert.*;

public class InsertCourseUseCaseTest {
    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void insertCourseTest(){
        InMemoryCourseDaoImpl inMemoryCourseDao = new InMemoryCourseDaoImpl();
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
        assertEquals(1, inMemoryCourseDao.getCourseList().size());
    }

}
