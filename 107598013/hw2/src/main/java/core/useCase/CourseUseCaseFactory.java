package core.useCase;

import core.boundary.input.AddCourseInputData;
import core.boundary.input.DeleteCourseInputData;
import core.boundary.input.UpdateCourseInputData;
import core.boundary.input.UseCase;
import core.boundary.output.IAddCoursePresenter;
import core.boundary.output.IDeleteCoursePresenter;
import core.boundary.output.IGetAllCoursePresenter;
import core.boundary.output.IUpdateCoursePresenter;
import core.boundary.require.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseUseCaseFactory implements ICourseUseCaseFactory {
    private ICourseRepository repository;

    @Autowired
    public CourseUseCaseFactory(ICourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public UseCase createAddCourseUseCase(AddCourseInputData inputData, IAddCoursePresenter presenter) {
        return new AddCourseUseCase(repository, inputData, presenter);
    }

    @Override
    public UseCase createDeleteCourseUseCase(DeleteCourseInputData inputData, IDeleteCoursePresenter presenter) {
        return new DeleteCourseUseCase(repository, inputData, presenter);
    }

    @Override
    public UseCase createUpdateCourseUseCase(UpdateCourseInputData inputData, IUpdateCoursePresenter presenter) {
        return new UpdateCourseUseCase(repository, inputData, presenter);
    }

    @Override
    public UseCase createGetAllCourseUseCase(IGetAllCoursePresenter presenter) {
        return new GetAllCoursesUseCase(repository, presenter);
    }
}
