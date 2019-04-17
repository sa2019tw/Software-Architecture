package service;

import entity.Course;
import mock.MockCourseDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CourseServiceTest {
    private CourseService service;
    private Course course1;
    private Course course2;

    @Before
    public void setUp() throws Exception {
        service = new CourseService();
        List<Course> courses = Arrays.asList(getSampleCourse1(), getSampleCourse2());
        Field fieldDao = CourseService.class.getDeclaredField("courseDao");
        fieldDao.setAccessible(true);
        fieldDao.set(service, new MockCourseDao(courses));
    }

    @After
    public void tearDown() throws Exception {
        service = null;
    }

    @Test
    public void addLegalCourse() {
        Course course = new Course();
        course.setTitle("test");
        assertTrue(service.addCourse(course));
    }

    @Test
    public void addIllegalCourse() {
        Course course = new Course();
        assertFalse(service.addCourse(course));

        course.setTitle("");
        assertFalse(service.addCourse(course));
    }

    @Test
    public void getExistCourseForUpdate() {
        Optional<Course> result = service.getCourseForUpdate(1);
        assertTrue(result.isPresent());
    }

    @Test
    public void getNotExistCourseForUpdate() {
        Optional<Course> result = service.getCourseForUpdate(3);
        assertFalse(result.isPresent());
    }

    @Test
    public void updateExistCourse() {
        Course course = new Course();
        course.setId(1);
        assertTrue(service.updateCourse(course));
    }

    @Test
    public void updateNotExistCourse() {
        Course course = new Course();
        course.setId(3);
        assertFalse(service.updateCourse(course));
    }

    @Test
    public void deleteExistCourse() {
        assertTrue(service.deleteCourse(1));
    }

    @Test
    public void deleteNotExistCourse() {
        assertFalse(service.deleteCourse(3));
    }

    @Test
    public void getAllCourses() {
        List<Course> exptected = Arrays.asList(getSampleCourse1(), getSampleCourse2());
        assertEquals(exptected.toString(), service.getAllCourses().toString());
    }

    private Course getSampleCourse1() {
        Course result = new Course();
        result.setId(1);
        result.setDescription("ooad description");
        result.setSuitablePeople("ooad suitable people");
        result.setPrice(10000);
        result.setAnnouncement("ooad announcement");
        result.setRemark("ooad remark");
        return result;
    }

    private Course getSampleCourse2() {
        Course result = new Course();
        result.setId(2);
        result.setDescription("database description");
        result.setSuitablePeople("database suitable people");
        result.setPrice(5000);
        result.setAnnouncement("database announcement");
        result.setRemark("database remark");
        return result;
    }
}