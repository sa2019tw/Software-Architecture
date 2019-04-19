package presenter;

import error.CourseError;
import output.Output;
import output.deleteCourseOutput;
import view.ViewModel;

public class deleteCoursePresenter implements Presenter, deleteCourseOutput {
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
