package UseCase.FindAllCourse;

import Domain.Course;
import Domain.CourseBase;
import UseCase.*;

import java.util.ArrayList;
import java.util.List;

public class FindAllCourseUseCase implements UseCase<FindAllCourseInput, CourseOutput> {
    private CourseBase courseBase;

    public FindAllCourseUseCase(CourseBase courseBase) {
        this.courseBase = courseBase;
    }

    public void execute(FindAllCourseInput input, CourseOutput output) {
        ArrayList<Course> courseArrayList = this.courseBase.fetchAllCourse();
        List<CourseDTO> courseDTOList = new CourseDTOMapper().mappingCourseListToCourseDTOList(courseArrayList);
        output.setCourseDTOList(courseDTOList);
    }
}
