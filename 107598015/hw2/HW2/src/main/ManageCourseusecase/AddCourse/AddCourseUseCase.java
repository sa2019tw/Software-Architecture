package main.ManageCourseusecase.AddCourse;

import main.Repository.ICourseDao;
import main.entity.Course;

import java.io.IOException;

public class AddCourseUseCase{
    private String courseName;
    private String courseDescription;
    private String applicableObject;
    private int price;
    private String precautions;
    private String remark;
    private static ICourseDao iCourseDao;
    public AddCourseUseCase(ICourseDao iCourseDao)
    {
        this.iCourseDao=iCourseDao;
    }

    public static void execute(AddCourseInput input, AddCourseOutput output) throws IOException {
        Course c=new Course(input.getCourseName(),input.getCourseDescription(),input.getApplicableObject(),input.getPrice(),input.getPrecautions(),input.getRemark());
        iCourseDao.add(c);
    }
}
