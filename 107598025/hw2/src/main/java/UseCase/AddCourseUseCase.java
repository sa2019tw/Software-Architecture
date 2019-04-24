package UseCase;

import Dao.ICourseDao;
import Entity.Course;
import Input.Input;

public class AddCourseUseCase implements UseCase {

    private ICourseDao courseDao;

    public AddCourseUseCase(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(Input input, OutputBoundary output){
        Course course = new Course(input.courseName,
                input.courseDescription,
                input.courseTarget,
                input.coursePrice,
                input.courseAttention,
                input.courseRemark);

//        courseDao.addCourse(course);
        output.stateSuccess(courseDao.addCourse(course));
    }
}
