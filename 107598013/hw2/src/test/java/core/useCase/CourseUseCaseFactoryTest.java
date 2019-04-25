package core.useCase;

import core.boundary.input.AddCourseInputData;
import core.boundary.input.DeleteCourseInputData;
import core.boundary.input.UpdateCourseInputData;
import core.boundary.output.IAddCoursePresenter;
import core.boundary.output.IDeleteCoursePresenter;
import core.boundary.output.IUpdateCoursePresenter;
import core.boundary.require.ICourseRepository;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class CourseUseCaseFactoryTest {
    @Tested
    private CourseUseCaseFactory factory;
    @Injectable
    private ICourseRepository repository;

    @Injectable
    private AddCourseInputData addCourseInputData;
    @Injectable
    private IAddCoursePresenter addCoursePresenter;

    @Injectable
    private DeleteCourseInputData deleteCourseInputData;
    @Injectable
    private IDeleteCoursePresenter deleteCoursePresenter;

    @Injectable
    private UpdateCourseInputData updateCourseInputData;
    @Injectable
    private IUpdateCoursePresenter updateCoursePresenter;

    @Test
    public void createAddCourseUseCase(@Mocked final AddCourseUseCase useCase) {
        factory.createAddCourseUseCase(addCourseInputData, addCoursePresenter);

        new Verifications() {{
            new AddCourseUseCase(repository, addCourseInputData, addCoursePresenter); times = 1;
        }};
    }

    @Test
    public void createDeleteCourseUseCase(@Mocked final DeleteCourseUseCase useCase) {
        factory.createDeleteCourseUseCase(deleteCourseInputData, deleteCoursePresenter);

        new Verifications() {{
            new DeleteCourseUseCase(repository, deleteCourseInputData, deleteCoursePresenter); times = 1;
        }};
    }

    @Test
    public void createUpdateCourseUseCase(@Mocked final UpdateCourseUseCase useCase) {
        factory.createUpdateCourseUseCase(updateCourseInputData, updateCoursePresenter);

        new Verifications() {{
            new UpdateCourseUseCase(repository, updateCourseInputData, updateCoursePresenter); times = 1;
        }};
    }
//
//    @Test
//    public void createGetAllCourseUseCase(@Mocked final GetAllCoursesUseCase useCase, @Mocked SimpleCourseListPresenter presenter) {
//        factory.createGetAllCourseUseCase(requestModel, presenter);
//
//        new Verifications() {{
//            new GetAllCoursesUseCase(repository, presenter); times = 1;
//        }};
//    }
}