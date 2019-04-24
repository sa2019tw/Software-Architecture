package usecase.detailedCourse;

import input.detailedCourse.detailedCourseInput;
import output.detailedCourseOutput;
import usecase.UseCase;

public interface detailedCourseUseCase extends UseCase<detailedCourseInput,detailedCourseOutput> {
   void execute(detailedCourseInput input, detailedCourseOutput output);
}
