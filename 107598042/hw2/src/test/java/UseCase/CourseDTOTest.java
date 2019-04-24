package UseCase;

import Domain.Course;
import TestUtility.ObjectMother;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CourseDTOTest {
    public class ContentEqualToMatcher extends TypeSafeMatcher<CourseDTO> {

        Course expectedCourse;

        public ContentEqualToMatcher(Course course) {
            this.expectedCourse = course;
        }

        @Override
        protected boolean matchesSafely(CourseDTO acutalCourse) {
            return expectedCourse.getId() == acutalCourse.id &&
                    expectedCourse.getPrice() == acutalCourse.price &&
                    expectedCourse.getDescription() == acutalCourse.description &&
                    expectedCourse.getNotes() == acutalCourse.notes &&
                    expectedCourse.getSuitableObject() == acutalCourse.suitableObject &&
                    expectedCourse.getRemark() == acutalCourse.remark &&
                    expectedCourse.getCourseName() == acutalCourse.courseName;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("Equal to Course content: ")
                        .appendValue(expectedCourse);
        }

        @Override
        protected void describeMismatchSafely(CourseDTO actual, Description description) {
            description.appendText("is")
                       .appendValue(actual);
        }
    }

    public ContentEqualToMatcher contentEqualTo(Course course) {
        return new ContentEqualToMatcher(course);
    }
//
//    @Test
//    public void transferDomainEntityToDTO() {
//        Course course = ObjectMother.createCourse("OOAD");
//        CourseDTO courseDTO = new CourseDTO(course);
//
//        assertThat(courseDTO, contentEqualTo(course));
//    }
}