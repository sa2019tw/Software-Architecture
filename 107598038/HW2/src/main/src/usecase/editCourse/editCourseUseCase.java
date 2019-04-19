package usecase.editCourse;

import input.editCourse.editCourseInput;
import output.editCourseOutput;
import usecase.UseCase;

public interface editCourseUseCase extends UseCase<editCourseInput, editCourseOutput> {
    void execute(editCourseInput input ,editCourseOutput output);
}
