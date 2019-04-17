package main.ManageCourseusecase.DeleteCourse;

import main.Repository.ICourseDao;
import main.entity.Course;

import java.io.IOException;

public class DeleteCourseUseCase {
    private static ICourseDao iCourseDao;
    public DeleteCourseUseCase(ICourseDao iCourseDao)
    {
        this.iCourseDao=iCourseDao;
    }
    public static void execute(DeleteCourseIpute input, DeleteCourseOutput output) throws IOException {
        Course course=new Course(input.getCourseName(),input.getCourseDescription(),input.getApplicableObject(),input.getPrecautions(),input.getPrice(),input.getRemark());
        iCourseDao.delete(course);
    }
}
