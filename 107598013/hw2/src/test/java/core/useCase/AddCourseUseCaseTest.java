package core.useCase;

import core.boundary.input.AddCourseInputData;
import core.boundary.output.AddCourseOutputData;
import core.boundary.output.IAddCoursePresenter;
import core.boundary.require.ICourseRepository;
import core.entity.Course;
import core.useCase.mapper.CourseMapper;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class AddCourseUseCaseTest {
    @Tested
    private AddCourseUseCase useCase;
    @Injectable
    private ICourseRepository repository;
    @Injectable
    private AddCourseInputData inputData;
    @Injectable
    private IAddCoursePresenter presenter;

    @Before
    public void setUp() {
        new MockUp<CourseMapper>() {
            @Mock
            Course toCourse(AddCourseInputData inputData) {
                return new Course.Builder("test").build();
            }
        };
    }

    @Test
    public void addCourse() {
        new Expectations() {{
            repository.addCourse((Course) any); result = 1;
        }};

        useCase.execute();

        new Verifications() {{
            CourseMapper.toCourse(inputData); times = 1;
            repository.addCourse(withInstanceOf(Course.class)); times = 1;
            new AddCourseOutputData(1); times = 1;
            presenter.responseResult((AddCourseOutputData) any); times = 1;
        }};
    }
}