package delivery;

import core.boundary.output.DeleteCourseOutputData;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeleteCoursePresenterTest {
    @Tested
    private DeleteCourseController.Presenter presenter;
    @Injectable
    private DeleteCourseController controller;
    @Injectable
    private DeleteCourseOutputData outputData;

    @Test
    public void normalResult() {
        new Expectations() {{
            outputData.getRowEffected(); result = 1;
        }};

        IResponseModel responseModel = presenter.generateResponse();
        assertFalse(responseModel.isError());

        new Verifications() {{
            DeleteCourseResponseModel.getResultModel(anyString); times = 1;
        }};
    }

    @Test
    public void zeroRowEffected() {
        new Expectations() {{
            outputData.getRowEffected(); result = 0;
        }};

        IResponseModel responseModel = presenter.generateResponse();
        assertTrue(responseModel.isError());

        new Verifications() {{
            DeleteCourseResponseModel.getErrorModel(anyString); times = 1;
        }};
    }
}