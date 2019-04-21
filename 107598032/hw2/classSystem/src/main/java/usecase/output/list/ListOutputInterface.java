package usecase.output.list;

import model.Course;
import usecase.output.OutputInterface;

import java.util.List;

public interface ListOutputInterface extends OutputInterface {
    void setCourses(List<Course> courseList);
    List<Course> getCourses();
    Course getCourseById(int id);
}
