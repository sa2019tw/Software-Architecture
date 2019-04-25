package delivery;

import core.boundary.output.AddCourseOutputData;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddCoursePresenterTest {
    @Tested
    private AddCourseController.Presenter presenter;
    @Injectable
    private AddCourseController controller;
    @Injectable
    private AddCourseOutputData outputData;

    @Test
    public void normalResult() {
        new Expectations() {{
            outputData.getId(); result = 1;
        }};

        IResponseModel responseModel = presenter.generateResponse();
        assertFalse(responseModel.isError());

        new Verifications() {{
            AddCourseResponseModel.getResultModel(anyString); times = 1;
        }};
    }

    @Test
    public void zeroEffected() {
        new Expectations() {{
            outputData.getId(); result = 0;
        }};

        IResponseModel responseModel = presenter.generateResponse();
        assertTrue(responseModel.isError());

        new Verifications() {{
            AddCourseResponseModel.getErrorModel(anyString); times = 1;
        }};
    }
}