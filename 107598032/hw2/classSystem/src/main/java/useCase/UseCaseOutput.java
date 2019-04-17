package useCase;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class UseCaseOutput {
    private String errorMessage = "";
    private List<Course> courses = new ArrayList<>();
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    public void reportError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess(){
        if(this.errorMessage.isEmpty())
            return true;
        else
            return false;
    }

    public String getMessage() {
        return errorMessage;
    }

    public void setCourses(List<Course> courses){
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
