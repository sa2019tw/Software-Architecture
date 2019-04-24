package Gateway;

import TestUtility.ObjectMother;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import Domain.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class InMemoryCourseBaseTest {

    @Test
    public void fetchAllCourseAndCheckTheOrderIsCorrect() {
        CourseBase courseBase = ObjectMother.createCourseBase();

        ArrayList<Course> arrayList = courseBase.fetchAllCourse();

        assertThat(arrayList, contains(ObjectMother.createCourse("OOAD"), ObjectMother.createCourse("POSD")));
    }

    @Test
    public void createNewCourseInMemory() {
        CourseBase courseBase = ObjectMother.createCourseBase();
        Course insertCourse = ObjectMother.createCourse("OS");

        courseBase.createNewCourse(insertCourse);
        Course searchCourse = courseBase.fetchCourseById(insertCourse.getId());

        assertTrue(insertCourse.equals(searchCourse));
    }

    @Test
    public void deleteExistCourseInMemory() {
        Integer deleteIdentifier = 0;
        CourseBase courseBase = ObjectMother.createCourseBase();
        courseBase.deleteCourseById(deleteIdentifier);

        assertEquals(courseBase.fetchCourseById(deleteIdentifier), null);
    }

    @Test
    public void modifyExistCourseByIdInMemory() {
        int identifier = 0;
        CourseBase courseBase = ObjectMother.createCourseBase();
        courseBase.modifyExistCourseById(identifier, ObjectMother.createCourse("POSA"));

        Course modifiedCourse = courseBase.fetchCourseById(identifier);
        assertTrue(modifiedCourse.equals(ObjectMother.createCourse("POSA")));
    }

}
