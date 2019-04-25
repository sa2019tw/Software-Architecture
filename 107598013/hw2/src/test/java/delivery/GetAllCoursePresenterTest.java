package delivery;

import core.boundary.output.GetAllCourseOutputData;
import core.useCase.CourseDto;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GetAllCoursePresenterTest {
    @Tested
    private GetAllCourseController.Presenter presenter;
    @Injectable
    private GetAllCourseController controller;
    @Injectable
    private GetAllCourseOutputData outputData;

    private List<CourseDto> courses;

    @Before
    public void setUp() {
        courses = new ArrayList<>();
        courses.add(getCourse());
    }

    private CourseDto getCourse() {
        return new CourseDto.Builder("database")
                .id(1)
                .description("database description")
                .suitablePeople("database suitable people")
                .price(5000)
                .announcement("database announcement")
                .remark("database remark")
                .build();
    }

    @Test
    public void normalResult() {
        new Expectations() {{
            outputData.getCourseList(); result = courses;
        }};

        GetAllCourseResponseModel responseModel = presenter.generateResponse();
        assertFalse(responseModel.isError());
        assertEquals(1, responseModel.getCourseList().size());
        assertEquals("database", responseModel.getCourseList().get(0).getTitle());

        new Verifications() {{
            GetAllCourseResponseModel.getResultModel((List<ObservableCourse>) any); times = 1;
        }};
    }
}