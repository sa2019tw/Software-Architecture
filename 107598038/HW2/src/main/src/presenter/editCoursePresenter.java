package presenter;

import error.CourseError;
import output.editCourseOutput;
import view.ViewModel;

public class editCoursePresenter implements Presenter, editCourseOutput {
    CourseError error = new CourseError();
    @Override
    public ViewModel createView() {
        return null;
    }

    @Override
    public CourseError getCourseError() {
        return error;
    }
}
