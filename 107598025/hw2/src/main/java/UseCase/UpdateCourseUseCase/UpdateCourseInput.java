package UseCase.UpdateCourseUseCase;

import UseCase.Input;

public class UpdateCourseInput implements Input {
    private String courseName;
    private String courseDescription;
    private String courseTarget;
    private int coursePrice;
    private String courseAttention;
    private String courseRemark;

    public UpdateCourseInput(String courseName, String courseDescription, String courseTarget, int coursePrice, String courseAttention, String courseRemark){
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseTarget = courseTarget;
        this.coursePrice = coursePrice;
        this.courseAttention = courseAttention;
        this.courseRemark = courseRemark;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseDescription() {
        return courseDescription;
    }

    @Override
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String getCourseTarget() {
        return courseTarget;
    }

    @Override
    public void setCourseTarget(String courseTarget) {
        this.courseTarget = courseTarget;
    }

    @Override
    public int getCoursePrice() {
        return coursePrice;
    }

    @Override
    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    @Override
    public String getCourseAttention() {
        return courseAttention;
    }

    @Override
    public void setCourseAttention(String courseAttention) {
        this.courseAttention = courseAttention;
    }

    @Override
    public String getCourseRemark() {
        return courseRemark;
    }

    @Override
    public void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }
}
