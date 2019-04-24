package usecase.io.ReadAllUseCaseIO;

import Dto.CourseDto;

import java.util.List;

public class ReadAllUseCaseOutput implements ReadAllUseCaseOutputInterface {
    private List<CourseDto> courseDto = null;

    public void setCourseDto(List<CourseDto> courseDto){
        this.courseDto = courseDto;
    }

    public List<CourseDto> getCourseDto(){
        return courseDto;
    }

}
