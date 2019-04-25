package core.useCase;

import core.boundary.output.GetAllCourseOutputData;
import core.boundary.output.IGetAllCoursePresenter;
import core.boundary.require.ICourseRepository;
import core.entity.Course;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAllCoursesUseCaseTest {
    @Tested
    private GetAllCoursesUseCase useCase;
    @Injectable
    private ICourseRepository repository;
    @Injectable
    private IGetAllCoursePresenter presenter;
    private List<Course> courses;

    @Before
    public void setUp() {
        courses = new ArrayList<>();
        courses.add(new Course.Builder("test").build());
        courses.add(new Course.Builder("test1").build());
    }

    @Test
    public void getAllCourse() {
        new Expectations() {{
            repository.getAllCourse(); result = courses;
        }};

        useCase.execute();

        new Verifications() {{
            repository.getAllCourse(); times = 1;
            new GetAllCourseOutputData((List<CourseDto>) any); times = 1;
            presenter.responseResult((GetAllCourseOutputData) any); times = 1;
        }};
    }
}