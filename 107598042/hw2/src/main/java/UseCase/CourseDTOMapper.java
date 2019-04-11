package UseCase;

import Domain.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDTOMapper {

    public CourseDTO mappingCourseDomainToCourseDTO(Course mappedCourse) {
        if (mappedCourse == null)
            return new CourseDTO();

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.id = mappedCourse.getId();
        courseDTO.price = mappedCourse.getPrice();
        courseDTO.courseName = mappedCourse.getCourseName();
        courseDTO.notes = mappedCourse.getNotes();
        courseDTO.suitableObject = mappedCourse.getSuitableObject();
        courseDTO.description = mappedCourse.getDescription();
        courseDTO.remark = mappedCourse.getRemark();
        return courseDTO;
    }

    public List<CourseDTO> mappingCourseListToCourseDTOList(List<Course> cousrList) {

        ArrayList<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
        for (int i = 0; i < cousrList.size(); i++) {
            CourseDTO courseDTO = this.mappingCourseDomainToCourseDTO(cousrList.get(i));
            courseDTOList.add(courseDTO);
        }

        return courseDTOList;
    }
}
