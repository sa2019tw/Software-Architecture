package core.useCase;

import core.boundary.input.DeleteCourseInputData;
import core.boundary.input.UseCase;
import core.boundary.output.DeleteCourseOutputData;
import core.boundary.output.IDeleteCoursePresenter;
import core.boundary.require.ICourseRepository;

public class DeleteCourseUseCase implements UseCase {
    private ICourseRepository repository;
    private DeleteCourseInputData inputData;
    private IDeleteCoursePresenter presenter;

    public DeleteCourseUseCase(ICourseRepository repository, DeleteCourseInputData inputData, IDeleteCoursePresenter presenter) {
        this.repository = repository;
        this.inputData = inputData;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        int rowEffected = repository.deleteCourse(inputData.getId());
        presenter.responseResult(new DeleteCourseOutputData(rowEffected));
    }
}
