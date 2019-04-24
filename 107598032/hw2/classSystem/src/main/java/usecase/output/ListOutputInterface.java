package usecase.output;

import dto.CourseDto;
import usecase.output.OutputInterface;

import java.util.List;

public interface ListOutputInterface extends OutputInterface {
    void setCourses(List<CourseDto> courseList);
    List<CourseDto> getCourses();
    CourseDto getCourseById(int id);
}
