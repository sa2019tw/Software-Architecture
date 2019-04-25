package delivery;

import core.boundary.output.UpdateCourseOutputData;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UpdateCoursePresenterTest {
    @Tested
    private UpdateCourseController.Presenter presenter;
    @Injectable
    private UpdateCourseController controller;
    @Injectable
    private UpdateCourseOutputData outputData;

    @Test
    public void normalResult() {
        new Expectations() {{
            outputData.getRowEffected(); result = 1;
        }};

        IResponseModel responseModel = presenter.generateResponse();
        assertFalse(responseModel.isError());

        new Verifications() {{
            UpdateCourseResponseModel.getResultModel(anyString); times = 1;
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
            UpdateCourseResponseModel.getErrorModel(anyString); times = 1;
        }};
    }
}