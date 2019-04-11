package UseCase.DeleteCourse;

import Domain.Course;
import Domain.CourseBase;
import UseCase.*;

import java.util.ArrayList;
import java.util.List;

public class DeleteCourseUseCase implements UseCase<DeleteCourseInput, CourseOutput> {
    private CourseBase courseBase;

    public DeleteCourseUseCase(CourseBase courseBase) {
        this.courseBase = courseBase;
    }


    public void execute(DeleteCourseInput input, CourseOutput output) {
        this.courseBase.deleteCourseById(input.id);
        ArrayList<Course> courseArrayList = this.courseBase.fetchAllCourse();
        List<CourseDTO> courseDTOList = new CourseDTOMapper().mappingCourseListToCourseDTOList(courseArrayList);
        output.setCourseDTOList(courseDTOList);
    }
}
