package UseCase.UpdateCourse;

import Domain.Course;
import Domain.CourseBase;
import UseCase.*;

public class UpdateCourseUseCase implements UseCase<UpdateCourseInput, CourseOutput> {
    private final CourseBase courseBase;

    public UpdateCourseUseCase(CourseBase courseBase) {
        this.courseBase = courseBase;
    }

    public void execute(UpdateCourseInput input, CourseOutput output) {
        Course course = new Course(input.updateCourseDTO.courseName,
                input.updateCourseDTO.description,
                input.updateCourseDTO.notes,
                input.updateCourseDTO.remark,
                input.updateCourseDTO.suitableObject,
                input.updateCourseDTO.price);

        this.courseBase.modifyExistCourseById(input.id, course);

        output.setCourseDTO(new CourseDTOMapper().mappingCourseDomainToCourseDTO(course));

        output.setCourseDTOList(new CourseDTOMapper().mappingCourseListToCourseDTOList(this.courseBase.fetchAllCourse()));

    }
}
