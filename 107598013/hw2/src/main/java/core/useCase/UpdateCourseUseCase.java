package core.useCase;

import core.boundary.input.UpdateCourseInputData;
import core.boundary.input.UseCase;
import core.boundary.output.IUpdateCoursePresenter;
import core.boundary.output.UpdateCourseOutputData;
import core.boundary.require.ICourseRepository;
import core.useCase.mapper.CourseMapper;

public class UpdateCourseUseCase implements UseCase {
    private ICourseRepository repository;
    private UpdateCourseInputData inputData;
    private IUpdateCoursePresenter presenter;

    public UpdateCourseUseCase(ICourseRepository repository, UpdateCourseInputData inputData, IUpdateCoursePresenter presenter) {
        this.repository = repository;
        this.inputData = inputData;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        int rowEffected = repository.updateCourse(CourseMapper.toCourse(inputData));
        presenter.responseResult(new UpdateCourseOutputData(rowEffected));
    }
}
