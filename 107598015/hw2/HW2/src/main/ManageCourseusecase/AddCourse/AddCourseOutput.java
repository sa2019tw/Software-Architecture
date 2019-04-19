package main.ManageCourseusecase.AddCourse;
public class AddCourseOutput {
    private String coursename;

    public AddCourseOutput() {
        System.out.println("Add course success!");
    }

    public String getCourseName() {
        return coursename;
    }

    public void setCourseName(String coursename) {
        this.coursename=coursename;
    }


}
