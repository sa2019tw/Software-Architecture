package UseCase.DeleteCourseUseCase;

import Dao.ICourseDao;
import Output.OutputData;
import UseCase.Input;
import Output.DeleteCourseOutputData;
import UseCase.OutputBoundary;
import UseCase.UseCase;

public class DeleteCourseUseCase implements UseCase {
    private ICourseDao courseDao;

    public DeleteCourseUseCase(ICourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(Input deleteCourseInput, OutputBoundary deleteCourseOutput) {

        OutputData deleteCourseOutputData = new DeleteCourseOutputData(courseDao.deleteCourse(deleteCourseInput.getCourseName()));
        deleteCourseOutput.setOutputData(deleteCourseOutputData);
    }
}
