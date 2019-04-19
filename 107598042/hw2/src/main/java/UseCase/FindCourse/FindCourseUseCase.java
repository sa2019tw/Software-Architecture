package UseCase.FindCourse;

import Domain.Course;
import Domain.CourseBase;
import UseCase.*;

public class FindCourseUseCase implements UseCase<FindCourseInput, CourseOutput> {

    private CourseBase courseBase;

    public FindCourseUseCase(CourseBase courseBase) {
        this.courseBase = courseBase;
    }

    public void execute(FindCourseInput input, CourseOutput output) {
        Course course = this.courseBase.fetchCourseById(input.id);

        CourseDTO courseDTO = new CourseDTOMapper().mappingCourseDomainToCourseDTO(course);

        output.setCourseDTO(courseDTO);
    }
}
