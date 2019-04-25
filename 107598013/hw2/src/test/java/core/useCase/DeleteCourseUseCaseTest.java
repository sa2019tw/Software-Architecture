package core.useCase;

import core.boundary.input.DeleteCourseInputData;
import core.boundary.output.DeleteCourseOutputData;
import core.boundary.output.IDeleteCoursePresenter;
import core.boundary.require.ICourseRepository;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

public class DeleteCourseUseCaseTest {
    @Tested
    private DeleteCourseUseCase useCase;
    @Injectable
    private ICourseRepository repository;
    @Injectable
    private DeleteCourseInputData inputData;
    @Injectable
    private IDeleteCoursePresenter presenter;

    @Test
    public void normalDeleteCourse() {
        new Expectations() {{
            repository.deleteCourse(anyInt); result = 1;
        }};

        useCase.execute();

        new Verifications() {{
            repository.deleteCourse(anyInt); times = 1;
            new DeleteCourseOutputData(1); times = 1;
            presenter.responseResult((DeleteCourseOutputData) any); times = 1;
        }};
    }
}