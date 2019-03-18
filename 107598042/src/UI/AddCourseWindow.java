package UI;

import Presenter.*;

public class AddCourseWindow extends FormWindow {

    public AddCourseWindow(Presenter presenter) {
        super(presenter);
    }

    @Override
    String actionButtonName() {
        return "add new course";
    }

    @Override
    void invokeAction(CourseInputDTO courseInputDAO) {
        presenter.createNewCourse(courseInputDAO);
    }

    @Override
    public void loadSelectedCouseIntoTextField() {

    }
}




