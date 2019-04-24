package UseCase;

import Dao.ICourseDao;
import Entity.Course;
import Input.Input;

public class UpdateCourseUseCase implements UseCase {
    private ICourseDao courseDao;

    public UpdateCourseUseCase(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(Input input, OutputBoundary outputBoundary){
        Course course = new Course(input.courseName,
                input.courseDescription,
                input.courseTarget,
                input.coursePrice,
                input.courseAttention,
                input.courseRemark);

        courseDao.updateCourse(course);
    }
}
