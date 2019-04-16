package UseCase.DeleteCourse;

import Domain.CourseBase;
import TestUtility.ObjectMother;
import UseCase.CourseOutput;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matcher.*;

public class DeleteCourseUseCaseTest {


    @Test
    public void deleteCourse() {

        CourseBase courseBase = ObjectMother.createCourseBaseGivenDefaultTwoCourse();
        DeleteCourseUseCase deleteCourseUseCase = new DeleteCourseUseCase(courseBase);


        DeleteCourseInput deleteCourseInput = new DeleteCourseInput(0);

        CourseOutput deleteCourseOutput = new CourseOutput();

        deleteCourseUseCase.execute(deleteCourseInput, deleteCourseOutput);

        int courseSize = courseBase.fetchAllCourse().size();

        assertThat(courseSize, equalTo(1));
        assertThat(deleteCourseOutput.getCourseDTOList(), not(hasItem(ObjectMother.createCourseDTO("OOAD"))));
    }

}