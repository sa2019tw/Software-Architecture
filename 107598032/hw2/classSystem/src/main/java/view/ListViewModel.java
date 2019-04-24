package view;

import dto.CourseDto;

import java.util.List;

public class ListViewModel implements ViewModel<List<CourseDto>> {
    List<CourseDto> courseDtoList;
    @Override
    public ViewModel<List<CourseDto>> setViewModel(List<CourseDto> viewModel) {
        courseDtoList = viewModel;
        return this;
    }

    public List<CourseDto> getCourses(){
        return courseDtoList;
    }
}
