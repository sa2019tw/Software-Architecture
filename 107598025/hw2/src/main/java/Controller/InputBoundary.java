package Controller;

import Input.Input;
import UseCase.OutputBoundary;

public interface InputBoundary {
    void executeAddCourseUseCase(Input input, OutputBoundary output);
    void executeRetrieveAllCourseUseCase(Input input, OutputBoundary output);
    void executeRetrieveOneCourseUseCase(Input input, OutputBoundary output);
    void executeUpdateCourseUseCase(Input input, OutputBoundary output);
    void executeDeleteCourseUseCase(Input input, OutputBoundary output);
}
