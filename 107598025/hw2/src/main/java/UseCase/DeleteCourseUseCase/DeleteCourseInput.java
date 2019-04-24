package UseCase.DeleteCourseUseCase;

import UseCase.Input;

public class DeleteCourseInput implements Input {
    private String courseName;

    public DeleteCourseInput(String courseName){
        this.courseName = courseName;
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }

    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseDescription() {
        return null;
    }

    @Override
    public void setCourseDescription(String courseDescription) {

    }

    @Override
    public String getCourseTarget() {
        return null;
    }

    @Override
    public void setCourseTarget(String courseTarget) {

    }

    @Override
    public int getCoursePrice() {
        return 0;
    }

    @Override
    public void setCoursePrice(int coursePrice) {

    }

    @Override
    public String getCourseAttention() {
        return null;
    }

    @Override
    public void setCourseAttention(String courseAttention) {

    }

    @Override
    public String getCourseRemark() {
        return null;
    }

    @Override
    public void setCourseRemark(String courseRemark) {

    }
}