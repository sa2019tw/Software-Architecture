package Domain;

import TestUtility.ObjectMother;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    @Test
    public void createNewCourseGivenCourseName() throws Exception {
        Course course = ObjectMother.createCourse("software architecture");
        assertEquals(course.getCourseName(), "software architecture");
    }

    @Test
    public void settingCourseIdentifier() throws Exception {
        Course course = ObjectMother.createCourse("software architecture");
        course.setId(0);
        assertEquals(course.getId(), 0);
    }


    @Test
    public void settingCourseDescription() throws  Exception {
        Course course = ObjectMother.createCourse("software architecture");
        course.setDescription("this is a good course");
        assertEquals(course.getDescription(), "this is a good course");
    }

    @Test
    public void settingCoursePrice() throws Exception {
        Course course = ObjectMother.createCourse("software architecture");
        course.setPrice(1999.0);
        assertEquals(course.getPrice(), 1999.0, 0.0);
    }

    @Test
    public void settingCourseNotes() throws Exception {
        Course course = ObjectMother.createCourse("software architecture");
        course.setNotes("this course is a high level class and is only suitable for people those who Familiar with OO");
        assertEquals(course.getNotes(), "this course is a high level class and is only suitable for people those who Familiar with OO");
    }

    @Test
    public void settingCourseRemark() throws Exception {
        Course course = ObjectMother.createCourse("software architecture");
        course.setRemark("none");
        assertEquals(course.getRemark(), "none");
    }

    @Test
    public void settingSuitableObject() throws Exception {
        Course course = ObjectMother.createCourse("software architecture");
        course.setSuitableObject("Male");
        assertEquals(course.getSuitableObject(), "Male");
    }
}