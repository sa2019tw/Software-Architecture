package UseCase.UpdateCourseUseCase;

import Dao.ICourseDao;
import Entity.Course;
import Output.OutputData;
import UseCase.Input;
import Output.UpdateCourseOutputData;
import UseCase.OutputBoundary;
import UseCase.UseCase;

public class UpdateCourseUseCase implements UseCase {
    private ICourseDao courseDao;

    public UpdateCourseUseCase(ICourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(Input updateCourseInput, OutputBoundary updateCourseOutput) {
        Course course = new Course(updateCourseInput.getCourseName(),
                updateCourseInput.getCourseDescription(),
                updateCourseInput.getCourseTarget(),
                updateCourseInput.getCoursePrice(),
                updateCourseInput.getCourseAttention(),
                updateCourseInput.getCourseRemark());

        OutputData updateCourseOutputData = new UpdateCourseOutputData(courseDao.updateCourse(course));
        updateCourseOutput.setOutputData(updateCourseOutputData);
    }
}
