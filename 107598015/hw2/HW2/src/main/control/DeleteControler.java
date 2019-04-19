package main.control;
import main.ManageCourseusecase.DeleteCourse.DeleteCourseOutput;
import main.Repository.ICourseDao;
import main.Repository.InText;
import main.ManageCourseusecase.DeleteCourse.DeleteCourseIpute;
import main.ManageCourseusecase.DeleteCourse.DeleteCourseUseCase;

import java.io.IOException;

public class DeleteControler {
    ICourseDao iCourseDao=new InText();
    DeleteCourseUseCase deleteControler=new DeleteCourseUseCase(iCourseDao);
    DeleteCourseIpute in =new DeleteCourseIpute();
    DeleteCourseOutput out =new DeleteCourseOutput();
    public DeleteControler(String coursename) throws IOException {
        in.setCourseName(coursename);
//        exc();
    }
    public void exc() throws IOException {
        deleteControler.execute(in, out);
    }
}
