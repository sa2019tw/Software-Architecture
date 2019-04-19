package usecasetest;

import dao.CourseDaoInterface;
import dao.InMemoryCourseDao;
import io.UseCaseError;
import io.UseCaseInput;
import io.UseCaseOutput;
import org.junit.Before;
import usecase.CreateCourseUseCase;
import usecase.UpdateCourseUseCase;

import static org.junit.Assert.*;

public class UpdateCourseUseCaseTest {
    private CreateCourseUseCase createCourseUseCase;
    private UpdateCourseUseCase updateCourseUseCase;
    private CourseDaoInterface dao;
    @Before
    public void setUp() throws Exception {
        dao = new InMemoryCourseDao();
        createCourseUseCase = new CreateCourseUseCase(dao);
        updateCourseUseCase = new UpdateCourseUseCase(dao);
    }

    @org.junit.Test
    public void UpdateCourseUseCaseTest(){
        UseCaseInput useCaseInput = new UseCaseInput(
                1,
                "CleanArchitercture",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        UseCaseError useCaseError = new UseCaseError();
        createCourseUseCase.creat(useCaseInput, useCaseError);
        UseCaseOutput useCaseOutput = updateCourseUseCase.getcourse(useCaseInput, useCaseError);
        assertEquals(useCaseOutput.getName(), "CleanArchitercture");

        useCaseInput = new UseCaseInput(
                1,
                "C1",
                "大一",
                81000,
                "C",
                "",
                "remark"
        );
        updateCourseUseCase.update(useCaseInput, useCaseError);
        useCaseOutput = updateCourseUseCase.getcourse(useCaseInput, useCaseError);
        System.out.println(useCaseOutput.getName());
        assertEquals(useCaseOutput.getName(), "C1");
    }

}