package UseCase;

import Domain.CourseBase;
import UseCase.AddCourse.AddCourseInput;
import UseCase.AddCourse.AddCourseUseCase;
import UseCase.DeleteCourse.DeleteCourseInput;
import UseCase.DeleteCourse.DeleteCourseUseCase;
import UseCase.FindAllCourse.*;
import UseCase.FindCourse.FindCourseInput;
import UseCase.FindCourse.FindCourseUseCase;
import UseCase.UpdateCourse.UpdateCourseInput;
import UseCase.UpdateCourse.UpdateCourseUseCase;

public class UseCaseFacade {
    private CourseBase courseBase;


    public UseCaseFacade(CourseBase courseBase) {
        this.courseBase = courseBase;
    }

    public void executeFindAllCourseUseCase(FindAllCourseInput input, CourseOutput output) {
        FindAllCourseUseCase findAllCourseUseCase = new FindAllCourseUseCase(courseBase);
        findAllCourseUseCase.execute(input, output);
    }

    public void executeFindCourseUseCase(FindCourseInput input, CourseOutput output) {
        FindCourseUseCase findCourseUseCase = new FindCourseUseCase(this.courseBase);
        findCourseUseCase.execute(input, output);
    }

    public void executeDeleteCourseUseCase(DeleteCourseInput input, CourseOutput output) {
        DeleteCourseUseCase deleteCourseUseCase = new DeleteCourseUseCase(this.courseBase);
        deleteCourseUseCase.execute(input, output);
    }

    public void executeAddCourseUseCase(AddCourseInput input, CourseOutput output) {
        AddCourseUseCase addCourseUseCase = new AddCourseUseCase(this.courseBase);
        addCourseUseCase.execute(input, output);
    }

    public void executeUpdateCourseUseCase(UpdateCourseInput input, CourseOutput output) {
        UpdateCourseUseCase updateCourseUseCase = new UpdateCourseUseCase(this.courseBase);
        updateCourseUseCase.execute(input, output);
    }
}
