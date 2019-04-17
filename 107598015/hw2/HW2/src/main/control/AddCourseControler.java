package main.control;

import main.ManageCourseusecase.AddCourse.AddCourseOutput;
import main.Repository.ICourseDao;
import main.Repository.InText;
import main.ManageCourseusecase.AddCourse.AddCourseInput;
import main.ManageCourseusecase.AddCourse.AddCourseUseCase;


import java.io.IOException;

public class AddCourseControler {
    ICourseDao iCourseDao=new InText();
    AddCourseUseCase addCourseUseCase=new AddCourseUseCase(iCourseDao);
    AddCourseInput addCourseInput=new AddCourseInput();
    AddCourseOutput addCourseOutput=new AddCourseOutput();
    String title;
    String description;
    String suitable;
    String price;
    String notice;
    String other;
    public AddCourseControler(String title, String description, String suitable, String price, String notice, String other) throws IOException {
        if(title.equals("")){title="NULL";}
        if(description.equals("")){description="NULL";}
        if(suitable.equals("")){suitable="NULL";}
        if(price.equals("")){price="NULL";}
        if(notice.equals("")){notice="NULL";}
        if(other.equals("")){other="NULL";}
        this.title=title;
        this.description=description;
        this.suitable=suitable;
        this.price=price;
        this.notice=notice;
        this.other=other;
    }
    public void exc() {
        addCourseInput.setCourseName(title);
        addCourseInput.setCourseDescription(description);
        addCourseInput.setApplicableObject(suitable);
        addCourseInput.setPrecautions(notice);
        addCourseInput.setPrice(price);
        addCourseInput.setRemark(other);
        try {
            addCourseUseCase.execute(addCourseInput, addCourseOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
