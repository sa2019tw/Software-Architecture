package UseCase;

import java.util.ArrayList;
import java.util.List;

public class CourseOutput {
    private List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();;
    private CourseDTO selectedCourseDTO;

    public List<CourseDTO> getCourseDTOList() {
        return courseDTOList;
    }

    public void setCourseDTOList(List<CourseDTO> courseDTOList) {
        this.courseDTOList = courseDTOList;
    }

    public CourseDTO getSelectedCourseDTO() {
        return this.selectedCourseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.selectedCourseDTO = courseDTO;
    }
}
