package core.useCase;

import core.boundary.input.AddCourseInputData;
import core.boundary.input.UseCase;
import core.boundary.output.AddCourseOutputData;
import core.boundary.output.IAddCoursePresenter;
import core.boundary.require.ICourseRepository;
import core.useCase.mapper.CourseMapper;

public class AddCourseUseCase implements UseCase {
    private ICourseRepository repository;
    private AddCourseInputData inputData;
    private IAddCoursePresenter presenter;

    public AddCourseUseCase(ICourseRepository repository, AddCourseInputData inputData, IAddCoursePresenter presenter) {
        this.repository = repository;
        this.inputData = inputData;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        int id = repository.addCourse(CourseMapper.toCourse(inputData));
        presenter.responseResult(new AddCourseOutputData(id));
    }
}
