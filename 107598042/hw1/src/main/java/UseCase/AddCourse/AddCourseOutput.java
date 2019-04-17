package UseCase.AddCourse;

import UseCase.CourseDTO;
import UseCase.Output;

public class AddCourseOutput implements Output {
    private CourseDTO courseDTO;

    public AddCourseOutput() {

    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }
}
