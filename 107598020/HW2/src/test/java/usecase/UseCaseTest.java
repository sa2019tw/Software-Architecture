package usecase;

import com.google.inject.Guice;
import com.google.inject.Injector;
import controller.Presenter;
import entity.Course;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecase.courseCommandFactory.CourseCommandFactory;
import usecase.input.CourseDTO;
import usecase.testObject.TestModule;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UseCaseTest {
    private CourseDTO input = new CourseDTO(1, "", "", "", 100, "","");
    private Presenter presenter = new Presenter();
    private Injector injector;
    private CourseCommandFactory courseCommandFactory;

    @Before
    public void setUp() {
        injector = Guice.createInjector(new TestModule());
        courseCommandFactory = injector.getInstance(CourseCommandFactory.class);
    }

    @Test
    public void getAllCourseCommandTest() {
        try {
            CourseCommand getAllCourseCommand = courseCommandFactory.createGetAllCourseCommand(presenter);
            getAllCourseCommand.execute();

            List<CourseDTO> courses =  presenter.getAllCourses();
            assertEquals(2, courses.size());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void deleteCourseCommandTest() {
        try {
            courseCommandFactory = injector.getInstance(CourseCommandFactory.class);

            CourseCommand deleteCourseCommand = courseCommandFactory.createDeleteCourseCommand(input, presenter);
            deleteCourseCommand.execute();
            List<CourseDTO> courses = presenter.getAllCourses();
            assertEquals(1, courses.size());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void modifyCourseCommandTest() {
        try {
            courseCommandFactory = injector.getInstance(CourseCommandFactory.class);

            CourseDao database = injector.getInstance(CourseDao.class);
            List<Course> courses = database.getAllCourses();

            assertEquals(0, courses.get(1).getPrice());

            CourseCommand modifyCommand = courseCommandFactory.createModifyCourseCommand(input, presenter);
            modifyCommand.execute();

            List<CourseDTO> courseDTOs = presenter.getAllCourses();
            assertEquals(100, courseDTOs.get(1).getPrice());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void createCourseCommandTest() {
        try {
            courseCommandFactory = injector.getInstance(CourseCommandFactory.class);

            CourseDao database = injector.getInstance(CourseDao.class);
            List<Course> courses = database.getAllCourses();

            assertEquals(2, courses.size());

            CourseCommand createCourseCommand = courseCommandFactory.createCreateCourseCommand(input, presenter);
            createCourseCommand.execute();

            List<CourseDTO> courseDTOs = presenter.getAllCourses();
            assertEquals(3, courseDTOs.size());
            assertEquals(2, courseDTOs.get(2).getId());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
