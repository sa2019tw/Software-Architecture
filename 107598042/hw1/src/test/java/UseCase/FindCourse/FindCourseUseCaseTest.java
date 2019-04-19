package UseCase.FindCourse;

import Domain.CourseBase;
import Gateway.InMemoryCourseBase;
import TestUtility.ObjectMother;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class FindCourseUseCaseTest {


    @Before
    public void setUp() {

    }

    @Test
    public void findCourseById() {
        CourseBase courseBase = ObjectMother.createCourseBaseGivenDefaultTwoCourse();

        FindCourseUseCase findCourseUseCase = new FindCourseUseCase(courseBase);

        FindCourseInput findCourseInput = new FindCourseInput();
        findCourseInput.id = 0;


        FindCourseOutput findCourseOutput = new FindCourseOutput();


        findCourseUseCase.execute(findCourseInput, findCourseOutput);

        assertThat(findCourseOutput.getCourseDTO(), equalTo(ObjectMother.createCourseDTO("OOAD")));
    }

}