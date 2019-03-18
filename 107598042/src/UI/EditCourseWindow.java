package UI;

import Presenter.*;

public class EditCourseWindow extends FormWindow {
    public EditCourseWindow(Presenter presenter) {
        super(presenter);
    }

    @Override
    String actionButtonName() {
        return "Upate";
    }

    @Override
    void invokeAction(CourseInputDTO courseInputDAO) {
        presenter.modifyCourse(courseInputDAO);
    }



}
