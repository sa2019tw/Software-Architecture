package usecase.addCourse;

import input.addCourse.addCourseInput;
import output.addCourseOutput;
import usecase.UseCase;

public interface addCourseUseCase extends UseCase<addCourseInput, addCourseOutput> {
    void execute(addCourseInput input ,addCourseOutput output);
}
