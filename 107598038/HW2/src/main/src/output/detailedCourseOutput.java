package output;

import dto.CourseDto;
import error.CourseError;
import model.Course;

public interface detailedCourseOutput extends Output {
    void setCourse(CourseDto course);
    CourseError getCourseError();
}
