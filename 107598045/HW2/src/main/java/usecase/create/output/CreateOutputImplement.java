package usecase.create.output;

public class CreateOutputImplement implements CreateOutput{
    private String errorMessage = "";
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

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getCourseId() {
        return courseId;
    }
}
