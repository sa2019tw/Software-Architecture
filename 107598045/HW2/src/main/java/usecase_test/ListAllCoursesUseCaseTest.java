package usecase_test;

import dao.CourseDao;
import dao.impl.InMemoryCourseDao;
import org.junit.Before;
import org.junit.Test;
import usecase.CourseInput;
import usecase.CourseOutput;
import usecase.create.NewCoursesUseCaseImplement;
import usecase.create.input.CreateInput;
import usecase.create.input.CreateInputImplement;
import usecase.create.output.CreateOutput;
import usecase.create.output.CreateOutputImplement;
import usecase.read.ListAllCoursesUseCase;
import usecase.read.ListAllCoursesUseCaseImplement;
import usecase.read.input.ListAllInput;
import usecase.read.input.ListAllInputImplement;
import usecase.read.output.ListAllOutput;
import usecase.read.output.ListAllOutputImplement;

import static org.junit.Assert.assertEquals;


public class ListAllCoursesUseCaseTest {
    ListAllCoursesUseCase usecase;
    private CourseDao dao;

    @Before
    public void setUp() throws Exception {
        usecase = new ListAllCoursesUseCaseImplement();
        dao = new InMemoryCourseDao();
    }

    @Test
    public void ListAllCoursesUsecaseTest(){
        NewCoursesUseCaseImplement newUseCase = new NewCoursesUseCaseImplement();
        newUseCase.setRepository(dao);
        CreateInput newInput = new CreateInputImplement(
                "clean architecture",
                "detail",
                "people",
                81000,
                "note",
                "remark"
        );
        CreateOutput newOutput = new CreateOutputImplement();
        newUseCase.execute(newInput, newOutput);

        ListAllInput input = new ListAllInputImplement();
        ListAllOutput output = new ListAllOutputImplement();
        usecase.setRepository(dao);
        usecase.execute(input, output);

        assertEquals(newInput.getCourseName(), output.getCourseList().get(0).getCourseName());
        assertEquals(1, output.getCourseList().size());
    }
}