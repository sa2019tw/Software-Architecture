package usecase.output;

import usecase.input.CourseDTO;

import java.util.List;

public interface OutputBoundary {
    List<CourseDTO> getAllCourses();

    void setCoursesList(List<CourseDTO> results);

}
