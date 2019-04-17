package Domain.OutputBoundary;

import UseCase.CourseDTO;

import java.util.Collection;

public interface OutputBoundary {
    void setCourseDTOCollection(Collection<CourseDTO> courseDTOCollection);

    void setCourseDTO(CourseDTO courseDTO);
}
