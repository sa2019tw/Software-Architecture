package delivery;

import core.boundary.require.ICourseRepository;
import core.entity.Course;
import core.useCase.CourseUseCaseFactory;
import infrastructure.repository.InMemoryCourseRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UpdateCourseControllerTest {
    private ICourseRepository courseRepository;
    private UpdateCourseController controller;
    private CourseRequestModel requestModelWithId;

    @Before
    public void setUp() {
        courseRepository = new InMemoryCourseRepository();
        controller = new UpdateCourseController(new CourseUseCaseFactory(courseRepository));
        requestModelWithId = getRequestModelWithId();
    }

    private CourseRequestModel getRequestModelWithId() {
        return new CourseRequestModel.Builder("database")
                .id("1")
                .description("database description")
                .suitablePeople("database suitable people")
                .price("5000")
                .announcement("database announcement")
                .remark("database remark")
                .build();
    }

    private Course getCourse() {
        return new Course.Builder("database")
                .id(1)
                .description("database description")
                .suitablePeople("database suitable people")
                .price(5000)
                .announcement("database announcement")
                .remark("database remark")
                .build();
    }

    @Test
    public void updateExistingCourse() {
        courseRepository.addCourse(getCourse());
        UpdateCourseResponseModel responseModel = controller.updateCourse(requestModelWithId);
        assertFalse(responseModel.isError());
    }

    @Test
    public void updateNotExistingCourse() {
        UpdateCourseResponseModel responseModel = controller.updateCourse(requestModelWithId);
        assertTrue(responseModel.isError());
    }

    @Test (expected = NullPointerException.class)
    public void illegalRequestModel() {
        controller.updateCourse(new CourseRequestModel.Builder("title").build());
    }
}