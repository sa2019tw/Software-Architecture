package usecase.io.ReadAllUseCaseIO;

import Dto.CourseDto;
import usecase.io.Input;

import java.util.List;

public interface ReadAllUseCaseOutputInterface extends Input {
    public CourseDto coursedto = null;

    public void setCourseDto(List<CourseDto> courseDto);

    public List<CourseDto> getCourseDto();
}
