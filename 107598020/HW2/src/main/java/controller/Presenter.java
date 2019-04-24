package controller;

import usecase.input.CourseDTO;
import usecase.output.OutputBoundary;

import java.util.List;

public class Presenter implements OutputBoundary {
    private List<CourseDTO> courses = null;

    public List<CourseDTO> getAllCourses() {
        return courses;
    }

    public void setCoursesList(List<CourseDTO> results) {
        courses = results;
    }

}
