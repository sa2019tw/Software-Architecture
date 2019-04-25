package delivery;

import core.boundary.output.AddCourseOutputData;
import core.boundary.output.IAddCoursePresenter;
import core.entity.UnhandleException;
import core.useCase.ICourseUseCaseFactory;
import delivery.mapper.AddCourseInputDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AddCourseController {
    private ICourseUseCaseFactory useCaseFactory;

    @Autowired
    public AddCourseController(ICourseUseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    public AddCourseResponseModel addCourse(CourseRequestModel requestModel) {
        checkRequestModel(requestModel);
        try {
            Presenter presenter = new Presenter();
            useCaseFactory.createAddCourseUseCase(AddCourseInputDataMapper.toInputData(requestModel), presenter).execute();
            return presenter.generateResponse();
        } catch (UnhandleException e) {
            return AddCourseResponseModel.getErrorModel(e.getMessage());
        }
    }

    private void checkRequestModel(CourseRequestModel requestModel) {
        Objects.requireNonNull(requestModel);
        Objects.requireNonNull(requestModel.getTitle());
    }

    class Presenter implements IAddCoursePresenter {
        private AddCourseOutputData outputData;

        @Override
        public void responseResult(AddCourseOutputData outputData) {
            this.outputData = outputData;
        }

        public AddCourseResponseModel generateResponse() {
            if (outputData.getId() > 0)
                return AddCourseResponseModel.getResultModel("Add course successfully");
            else
                return AddCourseResponseModel.getErrorModel("Add course fail");
        }
    }
}
