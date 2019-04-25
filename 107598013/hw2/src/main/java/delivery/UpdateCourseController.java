package delivery;

import core.boundary.output.IUpdateCoursePresenter;
import core.boundary.output.UpdateCourseOutputData;
import core.entity.UnhandleException;
import core.useCase.ICourseUseCaseFactory;
import delivery.mapper.UpdateCourseInputDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UpdateCourseController {
    private ICourseUseCaseFactory useCaseFactory;

    @Autowired
    public UpdateCourseController(ICourseUseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    public UpdateCourseResponseModel updateCourse(CourseRequestModel requestModel) {
        checkRequestModel(requestModel);
        try {
            Presenter presenter = new Presenter();
            useCaseFactory.createUpdateCourseUseCase(UpdateCourseInputDataMapper.toInputData(requestModel), presenter).execute();
            return presenter.generateResponse();
        } catch (UnhandleException e) {
            return UpdateCourseResponseModel.getErrorModel(e.getMessage());
        }
    }

    private void checkRequestModel(CourseRequestModel requestModel) {
        Objects.requireNonNull(requestModel);
        Objects.requireNonNull(requestModel.getTitle());
        Objects.requireNonNull(requestModel.getId());
    }

    class Presenter implements IUpdateCoursePresenter {
        private UpdateCourseOutputData outputData;

        @Override
        public void responseResult(UpdateCourseOutputData outputData) {
            this.outputData = outputData;
        }

        public UpdateCourseResponseModel generateResponse() {
            if (outputData.getRowEffected() > 0)
                return UpdateCourseResponseModel.getResultModel("Update course successfully");
            else
                return UpdateCourseResponseModel.getErrorModel("Update course fail");
        }
    }
}
