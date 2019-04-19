package com.example.sa_hw.HW2UseCase;

import android.util.Log;

import com.example.sa_hw.CourseDTO;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourse;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseImpl;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseInput;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseInputImpl;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseOutput;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseOutputImpl;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourse;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseImpl;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseInput;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseInputImpl;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseOutput;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseOutputImpl;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourse;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseImpl;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseInput;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseInputImpl;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourse;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseImpl;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseInput;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseInputImpl;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseOutput;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseOutputImpl;

import org.junit.After;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class inMemoryRepositoryImplTest {

    CourseRepository courseRepository = new inMemoryRepositoryImpl();

    @After
    public void tearDown() throws Exception {
        courseRepository.destoryDB();
    }

    @Test
    public void create() {
        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);

        CreateCourseInput input = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput output = new CreateCourseOutputImpl();

        createCourseUC.execute(input,output);

        assertEquals("SA",output.getCourseName());
//        Log.d(1,)
    }

    @Test
    public void update() {
        CourseRepository courseRepository = new inMemoryRepositoryImpl();

        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);
        CreateCourseInput createInput = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput createOutput = new CreateCourseOutputImpl();
        createCourseUC.execute(createInput,createOutput);

        UpdateCourse updateCourseUC = new UpdateCourseImpl(courseRepository);
        UpdateCourseInput input = new UpdateCourseInputImpl("1", "POSD","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        UpdateCourseOutput output = new UpdateCourseOutputImpl();
        updateCourseUC.execute(input,output);

        assertEquals("POSD",output.getNewCourseName());
    }

    @Test
    public void delete() {
        CourseRepository courseRepository = new inMemoryRepositoryImpl();

        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);
        CreateCourseInput createInput = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput createOutput = new CreateCourseOutputImpl();
        createCourseUC.execute(createInput,createOutput);

        DeleteCourse deleteCourseUC = new DeleteCourseImpl(courseRepository);
        DeleteCourseInput input = new DeleteCourseInputImpl("1");
        DeleteCourseOutput output = new DeleteCourseOutputImpl();
        deleteCourseUC.execute(input,output);

        assertEquals("1",output.getMessage());
    }

    @Test
    public void readAll() {
        CourseRepository courseRepository = new inMemoryRepositoryImpl();
        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);

        CreateCourseInput createInputSA = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput createOutputSA = new CreateCourseOutputImpl();
        createCourseUC.execute(createInputSA,createOutputSA);

        CreateCourseInput createInputPOSD = new CreateCourseInputImpl("POSD","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput createOutputPOSD = new CreateCourseOutputImpl();
        createCourseUC.execute(createInputPOSD,createOutputPOSD);

//        ReadCourse readCourseUC = new ReadCourseImpl(courseRepository);
//        ReadCourseInput readCourseInput = new ReadCourseInputImpl()

        Iterator<Map.Entry<Integer,CourseDTO>>ans = courseRepository.readinmemory();
        Map.Entry<Integer,CourseDTO>entry = ans.next();
        assertEquals(1,entry.getKey().intValue());
        assertEquals("SA",entry.getValue().getCourseName());

        Map.Entry<Integer,CourseDTO>entry1 = ans.next();
        assertEquals(2,entry1.getKey().intValue());
        assertEquals("POSD",entry1.getValue().getCourseName());

    }

}