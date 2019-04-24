package UseCase.FindAllCourse;

import Domain.Course;
import Domain.CourseBase;
import TestUtility.ObjectMother;
import UseCase.CourseOutput;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.*;

public class FindAllCourseUseCaseTest {
    @Test
    public void findAllCourse() {

        CourseBase courseBase = ObjectMother.createCourseBaseGivenDefaultTwoCourse();

        FindAllCourseUseCase findAllCourseUseCase = new FindAllCourseUseCase(courseBase);


        FindAllCourseInput findAllCourseInput = new FindAllCourseInput();

        CourseOutput findAllCourseOutput = new CourseOutput();


        findAllCourseUseCase.execute(findAllCourseInput, findAllCourseOutput);

        assertThat(findAllCourseOutput.getCourseDTOList()
                , hasItems(ObjectMother.createCourseDTO("OOAD")
                , ObjectMother.createCourseDTO("POSD")));
    }
}