package usecase.delete;

import dao.CourseDao;
import usecase.UseCase;
import usecase.delete.input.DeleteInput;
import usecase.delete.output.DeleteOutput;

public interface DeleteCoursesUseCase extends UseCase<DeleteInput, DeleteOutput> {
    void setRepository(CourseDao courseDao);
    void execute(DeleteInput input, DeleteOutput output);
}
