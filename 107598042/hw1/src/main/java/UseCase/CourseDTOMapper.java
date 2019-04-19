package UseCase;

import Domain.Course;

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
}
