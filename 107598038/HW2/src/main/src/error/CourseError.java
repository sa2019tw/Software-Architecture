package error;

public class CourseError {
    private String errorMessage = "";

    public void reportError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isError() {
        if (this.errorMessage.isEmpty())
            return false;
        return true;
    }
}
