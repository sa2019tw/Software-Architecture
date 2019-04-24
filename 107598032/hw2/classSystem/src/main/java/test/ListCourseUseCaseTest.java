package test;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDaoImplement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import presenter.InsertPresenter;
import presenter.ListPresenter;
import usecase.input.insert.InsertInputImplement;
import usecase.input.insert.InsertInputInterface;
import usecase.input.list.ListInputImplement;
import usecase.input.list.ListInputInterface;
import usecase.insert.InsertUseCaseImplement;
import usecase.insert.InsertUseCaseInterface;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;

import static org.junit.Assert.assertEquals;

public class ListCourseUseCaseTest {
    CourseDaoInterface inMemoryCourseDao;
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
        InsertPresenter presenter = new InsertPresenter();
        insertUseCase.execute(input, presenter);
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void listCourseTest(){
        ListUseCaseInterface listUseCase = new ListUseCaseImplement();
        listUseCase.setRepository(inMemoryCourseDao);
        ListInputInterface input = new ListInputImplement();
        ListPresenter presenter = new ListPresenter();
        listUseCase.execute(input, presenter);
        assertEquals(1, presenter.getCourses().size());
    }
}
