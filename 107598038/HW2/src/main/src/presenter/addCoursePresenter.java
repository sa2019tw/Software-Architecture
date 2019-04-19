package presenter;

import error.CourseError;
import output.addCourseOutput;
import view.ViewModel;

public class addCoursePresenter implements Presenter,addCourseOutput {
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
