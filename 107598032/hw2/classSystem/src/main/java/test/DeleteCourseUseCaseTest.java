package test;

import dao.InMemoryCourseDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import useCase.*;

import static org.junit.Assert.assertEquals;

public class DeleteCourseUseCaseTest {
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
    public void deleteCourseTest(){
        DeleteCourseUseCase deleteCourseUseCase = new DeleteCourseUseCase();
        deleteCourseUseCase.setCourseDao(inMemoryCourseDao);
        UseCaseInput useCaseInput = new UseCaseInput(
                0,
                "",
                "",
                "",
                -1,
                "",
                ""
        );
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        deleteCourseUseCase.execute(useCaseInput, useCaseOutput);
        assertEquals(0, inMemoryCourseDao.getCourseList().size());
    }
}
