package core.boundary.output;

import core.useCase.CourseDto;

import java.util.Collections;
import java.util.List;

public class GetAllCourseOutputData {
    private List<CourseDto> courses;
    public GetAllCourseOutputData(List<CourseDto> courses) {
        this.courses = courses;
    }

    public List<CourseDto> getCourseList() {
        return Collections.unmodifiableList(courses);
    }
}
