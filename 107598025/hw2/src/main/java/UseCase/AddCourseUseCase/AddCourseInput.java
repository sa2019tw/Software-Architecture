package UseCase.AddCourseUseCase;

import UseCase.Input;

public class AddCourseInput implements Input {
    private String courseName;
    private String courseDescription;
    private String courseTarget;
    private int coursePrice;
    private String courseAttention;
    private String courseRemark;

    public AddCourseInput(String courseName, String courseDescription, String courseTarget, int coursePrice, String courseAttention, String courseRemark){
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseTarget = courseTarget;
        this.coursePrice = coursePrice;
        this.courseAttention = courseAttention;
        this.courseRemark = courseRemark;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseTarget() {
        return courseTarget;
    }

    public void setCourseTarget(String courseTarget) {
        this.courseTarget = courseTarget;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseAttention() {
        return courseAttention;
    }

    public void setCourseAttention(String courseAttention) {
        this.courseAttention = courseAttention;
    }

    public String getCourseRemark() {
        return courseRemark;
    }

    public void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }
}
