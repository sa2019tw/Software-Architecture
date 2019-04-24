package usecase_test;

import dao.CourseDao;
import dao.impl.InMemoryCourseDao;
import org.junit.Before;
import org.junit.Test;
import usecase.create.NewCoursesUseCase;
import usecase.create.NewCoursesUseCaseImplement;
import usecase.create.input.CreateInput;
import usecase.create.input.CreateInputImplement;
import usecase.create.output.CreateOutput;
import usecase.create.output.CreateOutputImplement;
import usecase.delete.DeleteCoursesUseCase;
import usecase.delete.DeleteCoursesUseCaseImplement;
import usecase.delete.input.DeleteInput;
import usecase.delete.input.DeleteInputImplement;
import usecase.delete.output.DeleteOutput;
import usecase.delete.output.DeleteOutputImplement;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DeleteCoursesUseCaseTest {
    private DeleteCoursesUseCase UseCase;
    private CourseDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        UseCase = new DeleteCoursesUseCaseImplement();
    }
    @Test
    public void DeleteCoursesTest(){
        NewCoursesUseCase newUseCase = new NewCoursesUseCaseImplement();
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

        String[] deleteCourseId = {"1", "3", "5"};
        DeleteInput input = new DeleteInputImplement(deleteCourseId);
        DeleteOutput output = new DeleteOutputImplement();

        UseCase.setRepository(dao);
        UseCase.execute(input, output);

        try {
            assertEquals(0, dao.getCourseList().size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}