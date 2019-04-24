package output;

import dto.CourseDto;
import error.CourseError;
import model.Course;

public interface findCourseOutput extends Output {
    void setCourse(CourseDto dto);
    CourseError getCourseError();
}
