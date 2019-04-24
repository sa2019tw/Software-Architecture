package view;

import dto.CourseDto;

public class EditViewModel implements ViewModel<CourseDto>{
    CourseDto courseDto;
    @Override
    public ViewModel<CourseDto> setViewModel(CourseDto viewModel) {
        courseDto = viewModel;
        return this;
    }

    public CourseDto getCourse(){
        return courseDto;
    }
}
