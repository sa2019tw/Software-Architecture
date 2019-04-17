package test;
import main.ManageCourseusecase.DeleteCourse.DeleteCourseOutput;
import main.ManageCourseusecase.EditCourse.EditCourseOutput;
import main.Repository.ICourseDao;
import main.Repository.inMemory;
import main.ManageCourseusecase.AddCourse.AddCourseInput;
import main.ManageCourseusecase.AddCourse.AddCourseOutput;
import main.ManageCourseusecase.AddCourse.AddCourseUseCase;
import main.ManageCourseusecase.DeleteCourse.DeleteCourseIpute;
import main.ManageCourseusecase.DeleteCourse.DeleteCourseUseCase;
import main.ManageCourseusecase.EditCourse.EditCourseCase;
import main.ManageCourseusecase.EditCourse.EditCourseInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class test {
    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void addCourseTest() throws IOException {
//      確定數量是否增加
        ICourseDao i=new inMemory();
        AddCourseInput in=new AddCourseInput();
        String coursename="Sc";
        String description="必修";
        String suitable="研一";
        String notice="抄筆記";
        int price=123;
        String other="ssss";
        in.setCourseName(coursename);
        in.setCourseDescription(description);
        in.setApplicableObject(suitable);
        in.setPrecautions(notice);
        in.setPrice(price);
        in.setRemark(other);
        AddCourseOutput out=new AddCourseOutput();
        AddCourseUseCase add=new AddCourseUseCase(i);
        add.execute(in,out);
        i.show().size();
        assertEquals(1,i.show().size());

    }
    @Test
    public void removeCourseTest() throws IOException {
//      先新增後刪除，確定數量是否減一
        ICourseDao i=new inMemory();
        AddCourseInput in=new AddCourseInput();
        String coursename="Sc";
        String description="必修";
        String suitable="研一";
        String notice="抄筆記";
        int price=123;
        String other="ssss";
        in.setCourseName(coursename);
        in.setCourseDescription(description);
        in.setApplicableObject(suitable);
        in.setPrecautions(notice);
        in.setPrice(price);
        in.setRemark(other);
        AddCourseOutput out=new AddCourseOutput();
        AddCourseUseCase add=new AddCourseUseCase(i);
        add.execute(in,out);

        ICourseDao i1=new inMemory();
        DeleteCourseIpute in1=new DeleteCourseIpute();
        String coursename1="Sc";
        in1.setCourseName(coursename1);
        DeleteCourseOutput out1=new DeleteCourseOutput();
        DeleteCourseUseCase delete=new DeleteCourseUseCase(i1);
        delete.execute(in1,out1);
        assertEquals(0,i.show().size());

    }
    @Test
    public void editCourseTest() throws IOException {
        ICourseDao i=new inMemory();
        AddCourseInput in=new AddCourseInput();
        String coursename="Sc";
        String description="必修";
        String suitable="研一";
        String notice="jjj";
        int price=111111;
        String other="ssss";
        in.setCourseName(coursename);
        in.setCourseDescription(description);
        in.setApplicableObject(suitable);
        in.setPrecautions(notice);
        in.setPrice(price);
        in.setRemark(other);
        AddCourseOutput out=new AddCourseOutput();
        AddCourseUseCase add=new AddCourseUseCase(i);
        add.execute(in,out);


        EditCourseInput editCourseInput=new EditCourseInput();
        EditCourseOutput editCourseOutput=new EditCourseOutput();
        editCourseInput.setCourseName(in.getCourseName());
        editCourseOutput.setCourseDescription("111");
        editCourseOutput.setApplicableObject("111");
        editCourseOutput.setPrecautions("111");
        editCourseOutput.setPrice(1111);
        editCourseOutput.setRemark("111");
        EditCourseCase Edit=new EditCourseCase(i);
        Edit.execute(editCourseInput,editCourseOutput);

        assertEquals(1111,i.show().get(0).getPrice());
    }
    @Test
    public void showAllCourse() throws IOException {
        ICourseDao i=new inMemory();
        AddCourseInput in=new AddCourseInput();
        String coursename="Sc";
        String description="必修";
        String suitable="研一";
        String notice="jjj";
        int price=4541;
        String other="ssss";
        in.setCourseName(coursename);
        in.setCourseDescription(description);
        in.setApplicableObject(suitable);
        in.setPrecautions(notice);
        in.setPrice(price);
        in.setRemark(other);
        AddCourseOutput out=new AddCourseOutput();
        AddCourseUseCase add=new AddCourseUseCase(i);
        add.execute(in,out);
        assertEquals("Sc",i.show().get(0).getCourseName());
    }
}
