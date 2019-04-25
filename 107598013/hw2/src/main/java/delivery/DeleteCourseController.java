package delivery;

import core.boundary.output.DeleteCourseOutputData;
import core.boundary.output.IDeleteCoursePresenter;
import core.entity.UnhandleException;
import core.useCase.ICourseUseCaseFactory;
import delivery.mapper.DeleteCourseInputDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DeleteCourseController {
    private ICourseUseCaseFactory useCaseFactory;

    @Autowired
    public DeleteCourseController(ICourseUseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    public DeleteCourseResponseModel deleteCourse(CourseRequestModel requestModel) {
        checkRequestModel(requestModel);
        try {
            Presenter presenter = new Presenter();
            useCaseFactory.createDeleteCourseUseCase(DeleteCourseInputDataMapper.toInputData(requestModel), presenter).execute();
            return presenter.generateResponse();
        } catch (UnhandleException e) {
            return DeleteCourseResponseModel.getErrorModel(e.getMessage());
        }
    }

    private void checkRequestModel(CourseRequestModel requestModel) {
        Objects.requireNonNull(requestModel);
        Objects.requireNonNull(requestModel.getId());
    }

    class Presenter implements IDeleteCoursePresenter {
        private DeleteCourseOutputData outputData;

        @Override
        public void responseResult(DeleteCourseOutputData outputData) {
            this.outputData = outputData;
        }

        public DeleteCourseResponseModel generateResponse() {
            if (outputData.getRowEffected() > 0)
                return DeleteCourseResponseModel.getResultModel("Delete course successfully");
            else
                return DeleteCourseResponseModel.getErrorModel("Delete course fail");
        }
    }
}
