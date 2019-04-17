package presenter;

import dto.CourseDto;
import error.CourseError;
import output.Output;
import view.ViewModel;

public interface Presenter<V extends ViewModel> extends Output {
    V createView();
}
