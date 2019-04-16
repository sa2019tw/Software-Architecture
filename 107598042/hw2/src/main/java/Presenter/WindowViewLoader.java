package Presenter;

import UI.AddCourseWindow;
import UI.EditCourseWindow;
import UseCase.UseCaseFacade;

public class WindowViewLoader implements ViewLoader {

    private AddCourseWindow addCourseWindow;
    private EditCourseWindow editCourseWindow;

    public void createEditCourseWindow(CoursePresenter coursePresenter, UseCaseFacade useCaseFacade) {
        editCourseWindow = new EditCourseWindow(coursePresenter, useCaseFacade);
    }

    public void createAddCourseWindow(CoursePresenter coursePresenter, UseCaseFacade useCaseFacade) {
        addCourseWindow = new AddCourseWindow(coursePresenter, useCaseFacade);
    }


}
