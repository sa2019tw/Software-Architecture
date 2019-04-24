package usecase.read;

import dao.CourseDao;
import usecase.UseCase;
import usecase.read.input.ListAllInput;
import usecase.read.output.ListAllOutput;

public interface ListAllCoursesUseCase extends UseCase<ListAllInput, ListAllOutput> {
    void setRepository(CourseDao courseDao);
    void execute(ListAllInput input, ListAllOutput output);
}
