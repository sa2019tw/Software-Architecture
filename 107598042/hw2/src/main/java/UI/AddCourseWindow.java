package UI;

import Presenter.*;
import UseCase.AddCourse.AddCourseInput;
import UseCase.UseCaseFacade;

public class AddCourseWindow extends FormWindow {

    private UseCaseFacade useCaseFacade;

    public AddCourseWindow(CoursePresenter presenter, UseCaseFacade useCaseFacade) {
        super(presenter);
        this.useCaseFacade = useCaseFacade;
    }

    @Override
    String actionButtonName() {
        return "add new course";
    }

    @Override
    void invokeAction(CourseInputDTO courseInputDAO) {

        AddCourseInput addCourseInput = new AddCourseInput(courseInputDAO.courseName,
                courseInputDAO.description,
                courseInputDAO.notes,
                courseInputDAO.remark,
                courseInputDAO.suitableObject,
                courseInputDAO.price);

        useCaseFacade.executeAddCourseUseCase(addCourseInput, coursePresenter);
    }

}




