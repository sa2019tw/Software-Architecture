package test;

import dao.InMemoryCourseDaoImplement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecase.delete.DeleteUseCaseImplement;
import usecase.delete.DeleteUseCaseInterface;
import usecase.input.delete.DeleteInputImplement;
import usecase.input.delete.DeleteInputInterface;
import usecase.input.insert.InsertInputImplement;
import usecase.input.insert.InsertInputInterface;
import usecase.insert.InsertUseCaseImplement;
import usecase.insert.InsertUseCaseInterface;
import usecase.output.delete.DeleteOutputImplement;
import usecase.output.delete.DeleteOutputInterface;
import usecase.output.insert.InsertOutputImplement;
import usecase.output.insert.InsertOutputInterface;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteCourseUseCaseTest {
    InMemoryCourseDaoImplement inMemoryCourseDao;
    @Before
    public void setUp() throws Exception{
        inMemoryCourseDao = new InMemoryCourseDaoImplement();
        InsertUseCaseInterface insertUseCase = new InsertUseCaseImplement();
        insertUseCase.setRepository(inMemoryCourseDao);
        InsertInputInterface input = new InsertInputImplement(
                0,
                "軟體架構",
                "clean architecture",
                "碩一",
                80000,
                "先修POSD、OOAD",
                "不要遲到"
        );
        InsertOutputInterface output = new InsertOutputImplement();
        insertUseCase.execute(input, output);
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void deleteCourseTest(){
        List<Integer> id = new ArrayList<>();
        id.add(0);
        DeleteUseCaseInterface deleteUseCase = new DeleteUseCaseImplement();
        deleteUseCase.setRepository(inMemoryCourseDao);
        DeleteInputInterface input = new DeleteInputImplement(id);
        DeleteOutputInterface output = new DeleteOutputImplement();
        deleteUseCase.execute(input, output);
        assertEquals(0, inMemoryCourseDao.getCourseList().size());
    }
}
