package view;

import dto.CourseDto;

import java.util.List;

public class CourseHomeViewModel implements ViewModel<List<CourseDto>> {
    List<CourseDto> courseAll;

    @Override
    public ViewModel<List<CourseDto>> setViewModel(List<CourseDto> viewModel) {
        courseAll = viewModel;
        return this;
    }

    public List<CourseDto> getCourseAll(){
        return courseAll;
    }
}
