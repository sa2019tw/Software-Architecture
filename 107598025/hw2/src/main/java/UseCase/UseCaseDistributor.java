package UseCase;

import Controller.InputBoundary;
import Dao.ICourseDao;
import Input.Input;

public class UseCaseDistributor implements InputBoundary {
    private ICourseDao courseDao;

    public UseCaseDistributor(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void executeAddCourseUseCase(Input input, OutputBoundary output){
        UseCase addCourseUseCase = new AddCourseUseCase(courseDao);
        addCourseUseCase.execute(input, output);
    }

    public void executeRetrieveAllCourseUseCase(Input input, OutputBoundary output){
        UseCase retrieveAllCourseUseCase = new RetrieveAllCourseUseCase(courseDao);
        retrieveAllCourseUseCase.execute(input, output);
    }

    public void executeRetrieveOneCourseUseCase(Input input, OutputBoundary output){
        UseCase retrieveOneCourseUseCase = new RetrieveOneCourseUseCase(courseDao);
        retrieveOneCourseUseCase.execute(input, output);
    }

    public void executeUpdateCourseUseCase(Input input, OutputBoundary output){
        UseCase updateCourseUseCase = new UpdateCourseUseCase(courseDao);
        updateCourseUseCase.execute(input, output);
    }

    public void executeDeleteCourseUseCase(Input input, OutputBoundary output){
        UseCase deleteCourseUseCase = new DeleteCourseUseCase(courseDao);
        deleteCourseUseCase.execute(input, output);
    }
}
