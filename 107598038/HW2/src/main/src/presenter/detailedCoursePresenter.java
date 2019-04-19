package presenter;

import dto.CourseDto;
import error.CourseError;
import output.detailedCourseOutput;
import view.detailedCourseViewModel;

public class detailedCoursePresenter implements detailedCourseOutput,Presenter<detailedCourseViewModel> {
    CourseDto course;
    CourseError error = new CourseError();
    @Override
    public void setCourse(CourseDto course) {
        this.course = course;
    }

    @Override
    public CourseError getCourseError() {
        return error;
    }

    @Override
    public detailedCourseViewModel createView() {
        detailedCourseViewModel viewModel = new detailedCourseViewModel();
        viewModel.setViewModel(course);
        return viewModel;
    }


}
