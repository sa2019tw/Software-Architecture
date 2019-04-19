package com.example.sa_hw;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.ListView;

import com.example.sa_hw.HW2Domain.HW2Course;
import com.example.sa_hw.HW2UseCase.CourseRepository;
import com.example.sa_hw.HW2UseCase.CourseRepositoryImpl;
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
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseOutput;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseOutputImpl;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourse;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseImpl;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseInput;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseInputImpl;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseOutput;
import com.example.sa_hw.HW2UseCase.UpdateCourse.UpdateCourseOutputImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UseCaseTest {

    Context appContext = InstrumentationRegistry.getTargetContext();
    CourseRepository courseRepository = new CourseRepositoryImpl(appContext);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        courseRepository.destoryDB();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.sa_hw", appContext.getPackageName());
    }

    @Test
    public void Create() {
//        Context appContext = InstrumentationRegistry.getTargetContext();

        CourseRepository courseRepository = new CourseRepositoryImpl(appContext);
        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);
        CreateCourseInput input = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput output = new CreateCourseOutputImpl();
        createCourseUC.execute(input,output);
        assertEquals("SA",output.getCourseName());

//        HW2Course courseSA = new HW2Course("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
//        courseRepository.create(courseSA);

        Cursor cursorAll = courseRepository.readAll();
//        Cursor cursor = courseRepository.getCourseByID("54");
//
//        cursor.moveToFirst();
//        Log.d("課程名字",cursor.getString(cursor.getColumnIndexOrThrow("name")));
//        assertEquals(1,cursor.getCount());


//        cursorAll.moveToFirst();
//        while (!cursorAll.isAfterLast()){
//            Log.d(cursorAll.getString(cursorAll.getColumnIndexOrThrow("name"))+" ::",cursorAll.getString(cursorAll.getColumnIndexOrThrow("_id")));
//            cursorAll.moveToNext();
//        }
    }

    @Test
    public void Update() {
        Context appContext = InstrumentationRegistry.getTargetContext();

        CourseRepository courseRepository = new CourseRepositoryImpl(appContext);

        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);
        CreateCourseInput createInput = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput createOutput = new CreateCourseOutputImpl();
        createCourseUC.execute(createInput,createOutput);

        Cursor cursor = courseRepository.getCourseByID("1");
        cursor.moveToFirst();
        assertEquals("SA",cursor.getString(cursor.getColumnIndexOrThrow("name")));

        UpdateCourse updateCourseUC = new UpdateCourseImpl(courseRepository);
        UpdateCourseInput input = new UpdateCourseInputImpl("1", "POSD","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        UpdateCourseOutput output = new UpdateCourseOutputImpl();
        updateCourseUC.execute(input,output);

        cursor = courseRepository.getCourseByID("1");
        cursor.moveToFirst();
        assertEquals(cursor.getString(cursor.getColumnIndexOrThrow("name")),output.getNewCourseName());
    }

    @Test
    public void Delete() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        CourseRepository courseRepository = new CourseRepositoryImpl(appContext);

        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);
        CreateCourseInput input = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput output = new CreateCourseOutputImpl();
        createCourseUC.execute(input,output);

        Cursor cursorAll = courseRepository.readAll();
        assertEquals(1, cursorAll.getCount());

        DeleteCourse deleteCourseUC = new DeleteCourseImpl(courseRepository);
        DeleteCourseInput deleteInput = new DeleteCourseInputImpl("1");
        DeleteCourseOutput deleteOutput = new DeleteCourseOutputImpl();
        deleteCourseUC.execute(deleteInput,deleteOutput);

        cursorAll = courseRepository.readAll();
        assertEquals(0, cursorAll.getCount());

        Log.d("message is here",deleteOutput.getMessage());
        assertEquals("1",deleteOutput.getMessage());
    }

    @Test
    public void Read() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        CourseRepository courseRepository = new CourseRepositoryImpl(appContext);

        CreateCourse createCourseUC = new CreateCourseImpl(courseRepository);
        CreateCourseInput createInput = new CreateCourseInputImpl("SA","let code clean","who is handsome",123,"can't use phone in class","at every Thursday");
        CreateCourseOutput createOutput = new CreateCourseOutputImpl();
        createCourseUC.execute(createInput,createOutput);

        Cursor cursor = courseRepository.readAll();
        cursor.moveToFirst();
        assertEquals("SA",cursor.getString(cursor.getColumnIndexOrThrow("name")));
    }

    @Test
    public void test(){
        List<String>test = new ArrayList<String>();
        Map<Integer, List> inMemoryMap = new TreeMap<>();

        test.add(0,"joe");
        test.add(1,"derry");

        Log.d("answer ", test.get(0));

//        inMemoryMap.put(0,test);
    }
}
