package test;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDaoImplement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecase.ListCourseUseCase;
import usecase.input.InputInterface;
import usecase.input.UseCaseInput;
import usecase.input.insert.InsertInputImplement;
import usecase.input.list.ListInputImplement;
import usecase.input.list.ListInputInterface;
import usecase.insert.InsertUseCaseImplement;
import usecase.insert.InsertUseCaseInterface;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;
import usecase.output.OutputInterface;
import usecase.output.UseCaseOutput;
import usecase.output.insert.InsertOutputImplement;
import usecase.output.list.ListOutputImplement;

import static org.junit.Assert.assertEquals;

public class ListCourseUseCaseTest {
    CourseDaoInterface inMemoryCourseDao;
    @Before
    public void setUp() throws Exception{
        inMemoryCourseDao = new InMemoryCourseDaoImplement();
        InsertUseCaseInterface insertUseCase = new InsertUseCaseImplement();
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
    public void listCourseTest(){
        ListUseCaseInterface listUseCase = new ListUseCaseImplement();
        listUseCase.setRepository(inMemoryCourseDao);
        ListInputImplement input = new ListInputImplement();
        ListOutputImplement output = new ListOutputImplement();
        listUseCase.execute(input, output);
        assertEquals(1, output.getCourses().size());
    }
}
