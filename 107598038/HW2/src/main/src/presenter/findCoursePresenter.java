package presenter;

import dto.CourseDto;
import error.CourseError;
import output.findCourseOutput;
import view.findCourseViewModel;

public class findCoursePresenter implements Presenter<findCourseViewModel>, findCourseOutput {
    CourseDto course;
    CourseError error = new CourseError();
    @Override
    public void setCourse(CourseDto dto) {
        this.course = dto;
    }

    @Override
    public CourseError getCourseError() {
        return error;
    }

    @Override
    public findCourseViewModel createView() {
        findCourseViewModel viewModel = new findCourseViewModel();
        viewModel.setViewModel(course);
        return viewModel;
    }
}
