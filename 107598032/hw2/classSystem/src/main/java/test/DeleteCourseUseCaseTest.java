package test;

import dao.InMemoryCourseDaoImplement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecase.delete.DeleteUseCaseImplement;
import usecase.delete.DeleteUseCaseInterface;
import usecase.input.delete.DeleteInputImplement;
import usecase.input.insert.InsertInputImplement;
import usecase.insert.InsertUseCaseImplement;
import usecase.output.delete.DeleteOutputImplement;
import usecase.output.insert.InsertOutputImplement;

import static org.junit.Assert.assertEquals;

public class DeleteCourseUseCaseTest {
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
    public void deleteCourseTest(){
        DeleteUseCaseInterface deleteUseCase = new DeleteUseCaseImplement();
        deleteUseCase.setRepository(inMemoryCourseDao);
        DeleteInputImplement input = new DeleteInputImplement(0);
        DeleteOutputImplement output = new DeleteOutputImplement();
        deleteUseCase.execute(input, output);
        assertEquals(0, inMemoryCourseDao.getCourseList().size());
    }
}
