package Controller;

import Output.RetrieveOneCourseOutputData;
import Presenter.*;
import UseCase.AddCourseUseCase.AddCourseInput;
import UseCase.DeleteCourseUseCase.DeleteCourseInput;
import UseCase.RetrieveAllCourseUseCase.RetrieveAllCourseInput;
import UseCase.RetrieveOneCourseUseCase.RetrieveOneCourseInput;
import UseCase.UpdateCourseUseCase.UpdateCourseInput;
import UseCase.UseCase;
import UseCase.UseCaseFactory;

public class Controller {

    private UseCaseFactory useCaseFactory;

    public Controller(UseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    public ViewModel addCourse(InputModel inputModel) {
        AddCourseInput addCourseInput = new AddCourseInput(inputModel.getCourseName(),
                inputModel.getCourseDescription(),
                inputModel.getCourseTarget(),
                Integer.parseInt(inputModel.getCoursePrice()),
                inputModel.getCourseAttention(),
                inputModel.getCourseRemark());

        AddCoursePresenter addCoursePresenter = new AddCoursePresenter();

        UseCase addCourseUseCase = useCaseFactory.createAddCourseUseCase();
        addCourseUseCase.execute(addCourseInput, addCoursePresenter);

        addCoursePresenter.buildViewModel();
        return addCoursePresenter.getViewModel();
    }

    public ViewModel retrieveOneCourse(InputModel inputModel) {
        RetrieveOneCourseInput retrieveOneCourseInput = new RetrieveOneCourseInput(inputModel.getCourseName());

        RetrieveOneCoursePresenter retrieveOneCoursePresenter = new RetrieveOneCoursePresenter();
        UseCase retrieveOneCourseUseCase = useCaseFactory.createRetrieveOneCourseUseCase();

        retrieveOneCourseUseCase.execute(retrieveOneCourseInput, retrieveOneCoursePresenter);

        retrieveOneCoursePresenter.buildViewModel();
        return retrieveOneCoursePresenter.getViewModel();
    }

    public ViewModel retrieveAllCourse() {
        RetrieveAllCourseInput retrieveAllCourseInput = new RetrieveAllCourseInput();
        UseCase retrieveAllCourseUseCase = useCaseFactory.createRetrieveAllCourseUseCase();
        RetrieveAllCoursePresenter retrieveAllCoursePresenter = new RetrieveAllCoursePresenter();
        retrieveAllCourseUseCase.execute(retrieveAllCourseInput, retrieveAllCoursePresenter);

        retrieveAllCoursePresenter.buildViewModel();
        return retrieveAllCoursePresenter.getViewModel();
    }

    public ViewModel updateCourse(InputModel inputModel) {
        UpdateCourseInput updateCourseInput = new UpdateCourseInput(inputModel.getCourseName(),
                inputModel.getCourseDescription(),
                inputModel.getCourseTarget(),
                Integer.parseInt(inputModel.getCoursePrice()),
                inputModel.getCourseAttention(),
                inputModel.getCourseRemark());

        UseCase updateCourseUseCase = useCaseFactory.createUpdateCourseUseCase();
        UpdateCoursePresenter updateCoursePresenter = new UpdateCoursePresenter();
        updateCourseUseCase.execute(updateCourseInput, updateCoursePresenter);

        updateCoursePresenter.buildViewModel();
        return updateCoursePresenter.getViewModel();
    }

    public ViewModel deleteCourse(InputModel inputModel) {
        DeleteCourseInput deleteCourseInput = new DeleteCourseInput(inputModel.getCourseName());
        UseCase deleteCourseUseCase = useCaseFactory.createDeleteOneCourseUseCase();
        DeleteCoursePresenter deleteCoursePresenter = new DeleteCoursePresenter();
        deleteCourseUseCase.execute(deleteCourseInput, deleteCoursePresenter);

        deleteCoursePresenter.buildViewModel();
        return deleteCoursePresenter.getViewModel();
    }

}
