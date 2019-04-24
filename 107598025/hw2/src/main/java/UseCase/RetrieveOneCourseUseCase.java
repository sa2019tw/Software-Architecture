package UseCase;

import Dao.ICourseDao;
import Entity.Course;
import Input.Input;
import Output.Output;

public class RetrieveOneCourseUseCase implements UseCase {
    private ICourseDao courseDao;

    public RetrieveOneCourseUseCase(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(Input input, OutputBoundary outputBoundary){
        Course course = new Course(input.courseName,
                                    input.courseDescription,
                                    input.courseTarget,
                                    input.coursePrice,
                                    input.courseAttention,
                                    input.courseRemark);

        course = courseDao.retrieveOneCourse(course);

        Output output = new Output(course.getCourseName(),
                                    course.getCourseDescription(),
                                    course.getCourseTarget(),
                                    course.getCoursePrice(),
                                    course.getCourseAttention(),
                                    course.getCourseRemark());

        outputBoundary.setOutput(output);
    }
}
