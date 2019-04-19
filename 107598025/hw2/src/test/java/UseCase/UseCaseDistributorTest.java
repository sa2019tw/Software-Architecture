package UseCase;

import Dao.ICourseDao;
import Dao.MockCourseDao;
import Input.Input;
import Presenter.Presenter;
import Presenter.ViewModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UseCaseDistributorTest {
    private Input input, input2;
    private OutputBoundary outputBoundary = new Presenter(new ViewModel());
    private ICourseDao courseDao = new MockCourseDao();

    @Before
    public void setUp() throws Exception {
        input = new Input("test", "this is a test", "hello", 1000, "attention pls", "no remark");
        input2 = new Input("test2", "this is a test2", "hello2", 3000, "attention2 pls", "no remark2");

    }

    @After
    public void tearDown() throws Exception {
        input = null;
        input2 = null;
    }

    @Test
    public void executeAddCourseUseCase() {
        UseCase addCourseUseCase = new AddCourseUseCase(courseDao);
        addCourseUseCase.execute(input, outputBoundary);
        assertTrue(outputBoundary.stateSuccess(true));
    }

    @Test
    public void executeRetrieveAllCourseUseCase() {
        UseCase addCourseUseCase = new AddCourseUseCase(courseDao);
        addCourseUseCase.execute(input, outputBoundary);
        addCourseUseCase.execute(input2, outputBoundary);

        UseCase retrieveAllCourseUseCase = new RetrieveAllCourseUseCase(courseDao);
        retrieveAllCourseUseCase.execute(input, outputBoundary);
        assertEquals(2, outputBoundary.getOutputList().size());
    }

    @Test
    public void executeRetrieveOneCourseUseCase() {
        UseCase addCourseUseCase = new AddCourseUseCase(courseDao);
        addCourseUseCase.execute(input, outputBoundary);
        addCourseUseCase.execute(input2, outputBoundary);

        UseCase retrieveOneCourseUseCase = new RetrieveOneCourseUseCase(courseDao);
        retrieveOneCourseUseCase.execute(input, outputBoundary);
        assertEquals("test", outputBoundary.getOutput().courseName);
    }

    @Test
    public void executeUpdateCourseUseCase() {
        UseCase addCourseUseCase = new AddCourseUseCase(courseDao);
        addCourseUseCase.execute(input, outputBoundary);
        addCourseUseCase.execute(input2, outputBoundary);

        Input input3 = new Input("test", "nothing", "who", 20000, "attention", "remark");
        UseCase updateCourseUseCase = new UpdateCourseUseCase(courseDao);
        updateCourseUseCase.execute(input3, outputBoundary);

        UseCase retrieveOneCourseUseCase = new RetrieveOneCourseUseCase(courseDao);
        retrieveOneCourseUseCase.execute(input, outputBoundary);
        assertEquals("nothing", outputBoundary.getOutput().courseDescription);
    }

    @Test
    public void executeDeleteCourseUseCase() {
        UseCase addCourseUseCase = new AddCourseUseCase(courseDao);
        addCourseUseCase.execute(input, outputBoundary);
        addCourseUseCase.execute(input2, outputBoundary);

        UseCase deleteCourseUseCase = new DeleteCourseUseCase(courseDao);
        deleteCourseUseCase.execute(input, outputBoundary);

        UseCase retrieveAllCourseUseCase = new RetrieveAllCourseUseCase(courseDao);
        retrieveAllCourseUseCase.execute(input, outputBoundary);
        assertEquals(1, outputBoundary.getOutputList().size());
    }
}