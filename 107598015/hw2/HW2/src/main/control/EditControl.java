package main.control;

import main.ManageCourseusecase.EditCourse.EditCourseOutput;
import main.Repository.ICourseDao;
import main.Repository.InText;
import main.ManageCourseusecase.EditCourse.EditCourseCase;
import main.ManageCourseusecase.EditCourse.EditCourseInput;

import java.io.IOException;

public class EditControl {
    ICourseDao iCourseDao=new InText();
    EditCourseCase editCourseCase=new EditCourseCase(iCourseDao);
    EditCourseInput in =new EditCourseInput();
    EditCourseOutput out =new EditCourseOutput();
    public EditControl(String coursename,String description,String suitable,String price,String notice,String other) throws IOException {
        in.setCourseName(coursename);
        out.setCourseDescription(description);
        out.setApplicableObject(suitable);
        out.setPrecautions(notice);
        out.setPrice(price);
        out.setRemark(other);
    }
    public void exc() throws IOException {
        editCourseCase.execute(in, out);
    }
}
