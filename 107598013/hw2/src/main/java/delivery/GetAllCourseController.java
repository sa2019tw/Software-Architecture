package delivery;

import core.boundary.output.GetAllCourseOutputData;
import core.boundary.output.IGetAllCoursePresenter;
import core.entity.UnhandleException;
import core.useCase.CourseDto;
import core.useCase.ICourseUseCaseFactory;
import delivery.mapper.ObservableCourseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllCourseController {
    private ICourseUseCaseFactory useCaseFactory;

    public GetAllCourseController(ICourseUseCaseFactory factory) {
        this.useCaseFactory = factory;
    }

    public GetAllCourseResponseModel getAllCourse() {
        try {
            Presenter presenter = new Presenter();
            useCaseFactory.createGetAllCourseUseCase(presenter).execute();
            return presenter.generateResponse();
        } catch (UnhandleException e) {
            return GetAllCourseResponseModel.getErrorModel(e.getMessage());
        }
    }

    class Presenter implements IGetAllCoursePresenter {
        private GetAllCourseOutputData outputData;

        @Override
        public void responseResult(GetAllCourseOutputData outputData) {
            this.outputData = outputData;
        }

        public GetAllCourseResponseModel generateResponse() {
            return GetAllCourseResponseModel.getResultModel(getObservableCourseList(outputData.getCourseList()));
        }

        private List<ObservableCourse> getObservableCourseList(List<CourseDto> courses) {
            return courses.stream()
                    .map(ObservableCourseMapper::toObservableCourse)
                    .collect(Collectors.toList());
        }
    }
}
