package usecase.delete.output;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class DeleteOutputImplement implements DeleteOutput {
    private String errorMessage = "";
    private List<Course> Courses = new ArrayList<>();

    @Override
    public void reportError(String message) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public boolean hasErrorOccur() {
        if (this.errorMessage.isEmpty())
            return false;
        return true;
    }

    public void setCourseList(List<Course> courses) {
        Courses = courses;
    }
    public List<Course> getCourseList() {
        return Courses;
    }
}
