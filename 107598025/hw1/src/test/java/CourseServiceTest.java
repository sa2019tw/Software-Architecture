import Dao.MockCourseDao;
import Entity.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.ICourseService;
import service.CourseService;

import static org.junit.Assert.*;

public class CourseServiceTest {

    private ICourseService courseService = new CourseService(new MockCourseDao());

    @Before
    public void setUp() {
        Course course1 = new Course("test1", "this is test1", "everyone", 100, "nothing", "nothing");
        Course course2 = new Course("test2", "this is test2", "no one", 1000, "no attention", "no remark");
        courseService.addCourse(course1);
        courseService.addCourse(course2);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void addAndRetrieveOneCourse() {
        Course course = new Course("abc", "this is abc", "me", 123, "attention?", "remark?");
        courseService.addCourse(course);

        assertEquals(courseService.retrieveOneCourse("abc"), course);
    }

    @Test
    public void retrieveAllCourse() {
        assertEquals(courseService.retrieveAllCourse().size(), 2);
    }

    @Test
    public void updateCourse() {
        Course course = new Course("test1", "this is test123123", "everyone", 100, "nothing", "nothing");
        courseService.updateCourse(course);
        assertEquals(courseService.retrieveOneCourse("test1").getCourseDescription(), "this is test123123");
    }

    @Test
    public void deleteCourse() {
        courseService.deleteCourse("test1");
        assertEquals(courseService.retrieveAllCourse().size(), 1);
        assertEquals(courseService.retrieveOneCourse("test2").getCourseName(), "test2");
    }
}