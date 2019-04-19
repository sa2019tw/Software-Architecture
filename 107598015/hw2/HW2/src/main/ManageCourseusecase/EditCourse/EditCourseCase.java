package main.ManageCourseusecase.EditCourse;
import main.Repository.ICourseDao;
import main.entity.Course;
import java.io.IOException;

public class EditCourseCase {
    private static ICourseDao iCourseDao;
    public EditCourseCase(ICourseDao iCourseDao)
    {
        this.iCourseDao=iCourseDao;
    }

    public static void execute(EditCourseInput input, EditCourseOutput output) throws IOException {
        Course course=new Course(input.getCourseName(),output.getCourseDescription(),output.getApplicableObject(),output.getPrice(),output.getPrecautions(),output.getRemark());
        iCourseDao.edit(course);
    }
}
