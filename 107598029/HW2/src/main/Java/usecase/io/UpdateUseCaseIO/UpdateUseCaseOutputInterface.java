package usecase.io.UpdateUseCaseIO;

import Dto.CourseDto;
import usecase.io.Output;

public interface UpdateUseCaseOutputInterface extends Output {
    public CourseDto coursedto = null;

    public void setCourseDto(CourseDto courseDto);

    public CourseDto getCourseDto();
}
