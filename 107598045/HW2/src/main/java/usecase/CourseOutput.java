package usecase;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseOutput {
    private String errorMessage = "";
    private List<Course> Courses = new ArrayList<>();
    private Course course;
    private int courseId;

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

    public void setTheCourse(Course theCourse) {
        this.course = theCourse;
    }
    public Course getTheCourse() {
        return course;
    }

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
