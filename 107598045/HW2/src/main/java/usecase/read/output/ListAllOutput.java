package usecase.read.output;

import model.Course;
import usecase.CourseDto;
import usecase.Output;

import java.util.List;

public interface ListAllOutput extends Output {
    void reportError(String message);
    String getErrorMessage();
    boolean hasErrorOccur();

    void setCourseList(List<Course> courses);
    List<Course> getCourseList();
}
