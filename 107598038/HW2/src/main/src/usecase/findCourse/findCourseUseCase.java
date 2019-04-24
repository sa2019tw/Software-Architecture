package usecase.findCourse;

import input.findCourse.findCourseInput;
import output.findCourseOutput;
import usecase.UseCase;

public interface findCourseUseCase extends UseCase<findCourseInput, findCourseOutput> {
    void execute(findCourseInput input,findCourseOutput output);
}
