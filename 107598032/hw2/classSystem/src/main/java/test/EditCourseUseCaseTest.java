package test;

import dao.InMemoryCourseDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import useCase.EditCourseUseCase;
import useCase.InsertCourseUseCase;
import useCase.UseCaseInput;
import useCase.UseCaseOutput;

import static org.junit.Assert.assertEquals;

public class EditCourseUseCaseTest {
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
    public void editCourseTest(){
        EditCourseUseCase editCourseUseCase = new EditCourseUseCase();
        editCourseUseCase.setCourseDao(inMemoryCourseDao);
        UseCaseInput useCaseInput = new UseCaseInput(
                0,
                "軟體架構",
                "clean architecture",
                "碩一",
                8000,
                "先修POSD、OOAD",
                "不要遲到"
        );
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        editCourseUseCase.execute(useCaseInput, useCaseOutput);
        assertEquals(8000, inMemoryCourseDao.getCourseById(0).getPrice());
    }
}
