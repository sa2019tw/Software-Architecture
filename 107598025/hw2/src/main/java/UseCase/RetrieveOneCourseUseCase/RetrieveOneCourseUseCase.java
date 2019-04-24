package UseCase.RetrieveOneCourseUseCase;

import Dao.ICourseDao;
import Entity.Course;
import Output.OutputData;
import Output.RetrieveOneCourseOutputData;
import UseCase.Input;
import UseCase.OutputBoundary;
import UseCase.UseCase;

public class RetrieveOneCourseUseCase implements UseCase {
    private ICourseDao courseDao;

    public RetrieveOneCourseUseCase(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(Input retrieveOneCourseInput, OutputBoundary retrieveOneCourseOutput){

        Course course = courseDao.retrieveOneCourse(retrieveOneCourseInput.getCourseName());
        OutputData retrieveOneCourseOutputData = new RetrieveOneCourseOutputData(course.getCourseName(),
                                                                    course.getCourseDescription(),
                                                                    course.getCourseTarget(),
                                                                    course.getCoursePrice(),
                                                                    course.getCourseAttention(),
                                                                    course.getCourseRemark());

        retrieveOneCourseOutput.setOutputData(retrieveOneCourseOutputData);
    }
}
