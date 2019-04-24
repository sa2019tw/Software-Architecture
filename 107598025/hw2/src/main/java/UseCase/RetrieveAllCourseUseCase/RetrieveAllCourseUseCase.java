package UseCase.RetrieveAllCourseUseCase;

import Dao.ICourseDao;
import Entity.Course;
import Output.OutputData;
import Output.RetrieveAllCourseOutputData;
import UseCase.Input;
import UseCase.UseCase;
import UseCase.OutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class RetrieveAllCourseUseCase implements UseCase {

    private ICourseDao courseDao;

    public RetrieveAllCourseUseCase(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(Input retrieveAllCourseInput, OutputBoundary retrieveAllCourseOutput){
        List<Course> courseList = courseDao.retrieveAllCourse();

        List<OutputData> outputDataList = new ArrayList<>();
        for(Course course: courseList){
            RetrieveAllCourseOutputData retrieveAllCourseOutputData = new RetrieveAllCourseOutputData(course.getCourseName(),
                                                                                    course.getCourseDescription(),
                                                                                    course.getCourseTarget(),
                                                                                    course.getCoursePrice(),
                                                                                    course.getCourseAttention(),
                                                                                    course.getCourseRemark());
            outputDataList.add(retrieveAllCourseOutputData);
        }

        retrieveAllCourseOutput.setOutputDataList(outputDataList);
    }
}
