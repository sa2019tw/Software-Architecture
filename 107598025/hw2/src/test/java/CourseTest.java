import Entity.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    private Course course1;
    private Course course2;

    @Before
    public void setUp() {
        System.out.println("Setup");
        course1 = new Course("test1", "this is test1", "everyone", 100, "nothing", "nothing more");
        course2 = new Course("test2", "this is test2", "only me", 1000, "no attention", "no remark");
    }

    @After
    public void tearDown() {
        System.out.println("Running: tearDown");
        course1 = null;
        course2 = null;
    }

    @Test
    public void getCourseName() {
        assertEquals(course1.getCourseName(), "test1");
        assertEquals(course2.getCourseName(), "test2");
    }

    @Test
    public void setCourseName() {
        assertEquals(course1.getCourseName(), "test1");
        course1.setCourseName("test01");
        assertEquals(course1.getCourseName(), "test01");
    }

    @Test
    public void getCourseDescription() {
        assertEquals(course1.getCourseDescription(), "this is test1");
        assertEquals(course2.getCourseDescription(), "this is test2");
    }

    @Test
    public void setCourseDescription() {
        assertEquals(course1.getCourseDescription(), "this is test1");
        course1.setCourseDescription("this is test01");
        assertEquals(course1.getCourseDescription(), "this is test01");
    }

    @Test
    public void getCourseTarget() {
        assertEquals(course1.getCourseTarget(), "everyone");
        assertEquals(course2.getCourseTarget(), "only me");
    }

    @Test
    public void setCourseTarget() {
        assertEquals(course1.getCourseTarget(), "everyone");
        course1.setCourseTarget("anyone");
        assertEquals(course1.getCourseTarget(), "anyone");
    }

    @Test
    public void getCoursePrice() {
        assertEquals(course1.getCoursePrice(), 100);
        assertEquals(course2.getCoursePrice(), 1000);
    }

    @Test
    public void setCoursePrice() {
        assertEquals(course1.getCoursePrice(), 100);
        course1.setCoursePrice(101);
        assertEquals(course1.getCoursePrice(), 101);
    }

    @Test
    public void getCourseAttention() {
        assertEquals(course1.getCourseAttention(), "nothing");
        assertEquals(course2.getCourseAttention(), "no attention");
    }

    @Test
    public void setCourseAttention() {
        assertEquals(course1.getCourseAttention(), "nothing");
        course1.setCourseAttention("nothing!");
        assertEquals(course1.getCourseAttention(), "nothing!");
    }

    @Test
    public void getCourseRemark() {
        assertEquals(course1.getCourseRemark(), "nothing more");
        assertEquals(course2.getCourseRemark(), "no remark");
    }

    @Test
    public void setCourseRemark() {
        assertEquals(course1.getCourseRemark(), "nothing more");
        course1.setCourseRemark("nothing again!");
        assertEquals(course1.getCourseRemark(), "nothing again!");
    }
}