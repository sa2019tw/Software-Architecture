package usecase.delete.output;

import model.Course;
import usecase.Output;

import java.util.List;

public interface DeleteOutput extends Output {
    void reportError(String message);
    String getErrorMessage();
    boolean hasErrorOccur();

    void setCourseList(List<Course> courses);
    List<Course> getCourseList();
}
