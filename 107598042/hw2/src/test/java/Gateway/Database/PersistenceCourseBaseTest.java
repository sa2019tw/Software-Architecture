package Gateway.Database;

import Domain.Course;
import Gateway.PersistenceCourseBase;
import TestUtility.ObjectMother;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PersistenceCourseBaseTest {
    PersistenceCourseBase courseBase;

    @Before
    public void setUp() throws Exception {
        courseBase = new PersistenceCourseBase();
        courseBase.clearCourseTable();
    }

    @Test
    public void createNewCourseAndFetchFromDB() {
        Course course = ObjectMother.createCourse("POSA");
        courseBase.createNewCourse(course);
        Course fetchCourse = courseBase.fetchCourseById(course.getId());
        assertThat(fetchCourse, equalTo(course));
    }

    @Test
    public void fetchAllCourse() {
        courseBase.createNewCourse(ObjectMother.createCourse("POSA"));
        courseBase.createNewCourse(ObjectMother.createCourse("OOAD"));
        ArrayList<Course> courseList = courseBase.fetchAllCourse();
        assertThat(courseList, contains(ObjectMother.createCourse("POSA"), ObjectMother.createCourse("OOAD")));
    }


    @Test
    public void modifyExistCourseById() {
        Course course = ObjectMother.createCourse("POSA");
        courseBase.createNewCourse(course);

        courseBase.modifyExistCourseById(course.getId(), ObjectMother.createCourse("BDA"));

        Course fetchCourse = courseBase.fetchCourseById(course.getId());
        assertThat(fetchCourse, equalTo(ObjectMother.createCourse("BDA")));
    }

    @Test
    public void deleteCourseById() throws Exception {
        Course course = ObjectMother.createCourse("POSA");
        courseBase.createNewCourse(course);
        courseBase.deleteCourseById(course.getId());
        assertThat(courseBase.fetchCourseById(course.getId()), equalTo(null));
    }

}