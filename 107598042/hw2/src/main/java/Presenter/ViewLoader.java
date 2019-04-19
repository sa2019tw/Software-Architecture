package Presenter;

import UseCase.UseCaseFacade;

public interface ViewLoader {
    void createAddCourseWindow(CoursePresenter coursePresenter, UseCaseFacade useCaseFacade);
    void createEditCourseWindow(CoursePresenter coursePresenter, UseCaseFacade useCaseFacade);
}
