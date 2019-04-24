package UseCase.FindCourse;
import UseCase.CourseDTO;

public class FindCourseOutput {

    private CourseDTO courseDTO;

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public CourseDTO getCourseDTO() {
        return this.courseDTO;
    }
}
