package UseCase.AddCourseUseCase;

import Output.OutputData;
import UseCase.Input;
import Output.AddCourseOutputData;
import UseCase.OutputBoundary;
import Dao.ICourseDao;
import Entity.Course;
import UseCase.UseCase;

public class AddCourseUseCase implements UseCase {

    private ICourseDao courseDao;

    public AddCourseUseCase(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(Input addCourseInput, OutputBoundary addCourseOutput){
        Course course = new Course(addCourseInput.getCourseName(),
                addCourseInput.getCourseDescription(),
                addCourseInput.getCourseTarget(),
                addCourseInput.getCoursePrice(),
                addCourseInput.getCourseAttention(),
                addCourseInput.getCourseRemark());

        boolean isSuccess = courseDao.addCourse(course);
        OutputData addCourseOutputData = new AddCourseOutputData(isSuccess);

        addCourseOutput.setOutputData(addCourseOutputData);
    }
}
