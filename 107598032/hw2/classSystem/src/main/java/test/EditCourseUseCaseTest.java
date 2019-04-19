package test;

import dao.InMemoryCourseDaoImplement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecase.EditCourseUseCase;
import usecase.InsertCourseUseCase;
import usecase.edit.EditUseCaseImplement;
import usecase.edit.EditUseCaseInterface;
import usecase.input.UseCaseInput;
import usecase.input.edit.EditInputImplement;
import usecase.input.insert.InsertInputImplement;
import usecase.insert.InsertUseCaseImplement;
import usecase.output.UseCaseOutput;
import usecase.output.edit.EditOutputImplement;
import usecase.output.insert.InsertOutputImplement;

import static org.junit.Assert.assertEquals;

public class EditCourseUseCaseTest {
    InMemoryCourseDaoImplement inMemoryCourseDao;
    @Before
    public void setUp() throws Exception{
        inMemoryCourseDao = new InMemoryCourseDaoImplement();
        InsertUseCaseImplement insertUseCase = new InsertUseCaseImplement();
        insertUseCase.setRepository(inMemoryCourseDao);
        InsertInputImplement input = new InsertInputImplement(
                0,
                "軟體架構",
                "clean architecture",
                "碩一",
                80000,
                "先修POSD、OOAD",
                "不要遲到"
        );
        InsertOutputImplement output = new InsertOutputImplement();
        insertUseCase.execute(input, output);
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void editCourseTest(){
        EditUseCaseImplement editUseCase = new EditUseCaseImplement();
        editUseCase.setRepository(inMemoryCourseDao);
        EditInputImplement input = new EditInputImplement(
                0,
                "軟體架構",
                "clean architecture",
                "碩一",
                8000,
                "先修POSD、OOAD",
                "不要遲到"
        );
        EditOutputImplement output = new EditOutputImplement();
        editUseCase.execute(input, output);
        assertEquals(8000, inMemoryCourseDao.getCourseById(0).getPrice());
    }
}
