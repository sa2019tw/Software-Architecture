package UseCase;

import Dao.ICourseDao;
import Entity.Course;
import Input.Input;
import Output.Output;

import java.util.ArrayList;
import java.util.List;

public class RetrieveAllCourseUseCase implements UseCase {

    private ICourseDao courseDao;

    public RetrieveAllCourseUseCase(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(Input input, OutputBoundary outputBoundary){
        List<Course> courseList = courseDao.retrieveAllCourse();
        List<Output> outputs = new ArrayList<Output>();

        for(Course course: courseList){
            Output output = new Output(course.getCourseName(),
                    course.getCourseDescription(),
                    course.getCourseTarget(),
                    course.getCoursePrice(),
                    course.getCourseAttention(),
                    course.getCourseRemark());
            outputs.add(output);
        }

        outputBoundary.setOutputList(outputs);
    }
}
