package main.control;

import main.ManageCourseusecase.ShowAllCourse.ShowAllCourseInput;
import main.ManageCourseusecase.ShowAllCourse.ShowAllCourseOutput;
import main.Repository.ICourseDao;
import main.Repository.InText;
import main.ManageCourseusecase.ShowAllCourse.ShowAllCourseUsecase;
import java.io.IOException;

public class ShowControler {
    ICourseDao iCourseDao=new InText();
    ShowAllCourseUsecase showAllCourseUsecase=new ShowAllCourseUsecase(iCourseDao);
    ShowAllCourseInput showAllCourseInput=new ShowAllCourseInput();
    public ShowAllCourseOutput showAllCourseOutput=new ShowAllCourseOutput();
    public ShowControler() throws IOException
    {
    }
    public void exc()
    {
        showAllCourseUsecase.execute(showAllCourseInput, showAllCourseOutput);
    }
}
