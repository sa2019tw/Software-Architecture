package presenter;

import dto.CourseDto;
import error.CourseError;
import model.Course;
import output.CourseHomeOutput;
import view.CourseHomeViewModel;
import view.ViewModel;

import java.util.List;

public class CourseHomePresenter implements CourseHomeOutput,Presenter<CourseHomeViewModel> {
    List<CourseDto> course;
    CourseError error = new CourseError();

    @Override
    public void setCourse(List<CourseDto> course) {
        this.course = course;
    }

    @Override
    public CourseError getCourseError() {
        return error;
    }

    @Override
    public CourseHomeViewModel createView(){
        CourseHomeViewModel viewModel = new CourseHomeViewModel();
        viewModel.setViewModel(course);
        return viewModel;
    }
}
