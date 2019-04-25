package core.useCase;

import core.boundary.input.UseCase;
import core.boundary.output.GetAllCourseOutputData;
import core.boundary.output.IGetAllCoursePresenter;
import core.boundary.require.ICourseRepository;
import core.useCase.mapper.CourseDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllCoursesUseCase implements UseCase {
    private ICourseRepository repository;
    private IGetAllCoursePresenter presenter;

    public GetAllCoursesUseCase(ICourseRepository repository, IGetAllCoursePresenter presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        List<CourseDto> courses = repository.getAllCourse().stream()
                .map(CourseDtoMapper::toCourseDto)
                .collect(Collectors.toList());
        presenter.responseResult(new GetAllCourseOutputData(courses));
    }
}
