package usecase.CourseHome;

import input.CouseHome.CourseHomeInput;
import output.CourseHomeOutput;
import usecase.UseCase;

public interface CourseHomeUseCase extends UseCase<CourseHomeInput, CourseHomeOutput> {
    void execute(CourseHomeInput input,CourseHomeOutput output);
}
