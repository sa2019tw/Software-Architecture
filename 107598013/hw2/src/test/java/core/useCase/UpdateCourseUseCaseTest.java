package core.useCase;

import core.boundary.input.UpdateCourseInputData;
import core.boundary.output.IUpdateCoursePresenter;
import core.boundary.output.UpdateCourseOutputData;
import core.boundary.require.ICourseRepository;
import core.entity.Course;
import core.useCase.mapper.CourseMapper;
import mockit.*;
import org.junit.Before;
import org.junit.Test;

public class UpdateCourseUseCaseTest {
    @Tested
    private UpdateCourseUseCase useCase;
    @Injectable
    private ICourseRepository repository;
    @Injectable
    private UpdateCourseInputData inputData;
    @Injectable
    private IUpdateCoursePresenter presenter;

    @Before
    public void setUp() throws Exception {
        new MockUp<CourseMapper>() {
            @Mock
            Course toCourse(UpdateCourseInputData inputData) {
                return new Course.Builder("test").build();
            }
        };
    }

    @Test
    public void normalUpdate() {
        new Expectations() {{
            repository.updateCourse((Course) any); result = 1;
        }};

        useCase.execute();

        new Verifications() {{
            CourseMapper.toCourse(inputData); times = 1;
            repository.updateCourse((Course) any); times = 1;
            new UpdateCourseOutputData(1); times = 1;
            presenter.responseResult((UpdateCourseOutputData) any); times = 1;
        }};
    }
}