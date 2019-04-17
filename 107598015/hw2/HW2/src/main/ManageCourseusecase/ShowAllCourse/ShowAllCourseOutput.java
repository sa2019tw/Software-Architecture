package main.ManageCourseusecase.ShowAllCourse;

import main.entity.Course;

import java.util.List;

public class ShowAllCourseOutput {
    private List<Course>allcourse;
    public ShowAllCourseOutput()
    {
        System.out.print("Show Course Success");
    }
    public void setAllCourse(List<Course> allcourse)
    {
        this.allcourse=allcourse;
    }

    public List<Course> getAllCourse()
    {
        return allcourse;
    }
}
