package output;

import dto.CourseDto;
import error.CourseError;

import java.util.List;

public interface CourseHomeOutput extends Output {
    void setCourse(List<CourseDto> course);
    CourseError getCourseError();
}
