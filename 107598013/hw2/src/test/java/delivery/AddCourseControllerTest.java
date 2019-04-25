package delivery;

import core.useCase.CourseUseCaseFactory;
import infrastructure.repository.InMemoryCourseRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class AddCourseControllerTest {
    private AddCourseController controller;
    private CourseRequestModel requestModelWithoutId;

    @Before
    public void setUp() {
        controller = new AddCourseController(new CourseUseCaseFactory(new InMemoryCourseRepository()));
        requestModelWithoutId = getRequestModelWithoutId();
    }

    private CourseRequestModel getRequestModelWithoutId() {
        return new CourseRequestModel.Builder("ooad")
                .description("ooad description")
                .suitablePeople("ooad suitable people")
                .price("10000")
                .announcement("ooad announcement")
                .remark("ooad remark")
                .build();
    }

    @Test
    public void addCourse() {
        AddCourseResponseModel responseModel = controller.addCourse(requestModelWithoutId);
        assertFalse(responseModel.isError());
    }
}