package delivery;

import core.boundary.require.ICourseRepository;
import core.entity.Course;
import core.useCase.CourseUseCaseFactory;
import infrastructure.repository.InMemoryCourseRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetAllCourseControllerTest {
    private GetAllCourseController controller;
    private ICourseRepository courseRepository;

    @Before
    public void setUp() throws Exception {
        courseRepository = new InMemoryCourseRepository();
        controller = new GetAllCourseController(new CourseUseCaseFactory(courseRepository));
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
    public void getAllCourse() {
        courseRepository.addCourse(getCourse());

        GetAllCourseResponseModel responseModel = controller.getAllCourse();
        assertEquals(1, responseModel.getCourseList().size());
        assertEquals("database", responseModel.getCourseList().get(0).getTitle());
    }
}