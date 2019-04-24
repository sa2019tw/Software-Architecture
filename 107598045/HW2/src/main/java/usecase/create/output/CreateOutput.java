package usecase.create.output;

import usecase.Output;

public interface CreateOutput extends Output {
    void reportError(String message);
    String getErrorMessage();
    boolean hasErrorOccur();

    void setCourseId(int courseId);
    int getCourseId();
}
