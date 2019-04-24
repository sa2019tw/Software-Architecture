package usecase.io.UpdateUseCaseIO;

import Dto.CourseDto;

import java.util.List;

public class UpdateUseCaseOutput implements UpdateUseCaseOutputInterface {
    private CourseDto courseDto = null;

    public void setCourseDto(CourseDto courseDto){
        this.courseDto = courseDto;
    }

    public CourseDto getCourseDto(){
        return courseDto;
    }

}
