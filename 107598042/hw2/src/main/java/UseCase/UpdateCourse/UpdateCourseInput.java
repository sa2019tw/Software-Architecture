package UseCase.UpdateCourse;

import UseCase.CourseDTO;

public class UpdateCourseInput {
    int id;
    CourseDTO updateCourseDTO;
    public UpdateCourseInput(int id, CourseDTO updateCourseDTO) {
        this.id = id;
        this.updateCourseDTO = updateCourseDTO;
    }
}
