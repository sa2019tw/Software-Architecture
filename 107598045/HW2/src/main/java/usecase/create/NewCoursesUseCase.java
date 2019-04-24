package usecase.create;

import dao.CourseDao;
import usecase.UseCase;
import usecase.create.input.CreateInput;
import usecase.create.output.CreateOutput;

public interface NewCoursesUseCase extends UseCase<CreateInput, CreateOutput> {
    void setRepository(CourseDao courseDao);
    void execute(CreateInput input, CreateOutput output);
}
