package UseCase.FindCourse;

import Domain.CourseBase;
import Gateway.InMemoryCourseBase;
import TestUtility.ObjectMother;
import UseCase.CourseOutput;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class FindCourseUseCaseTest {



    @Test
    public void findCourseById() {
        CourseBase courseBase = ObjectMother.createCourseBaseGivenDefaultTwoCourse();

        FindCourseUseCase findCourseUseCase = new FindCourseUseCase(courseBase);

        FindCourseInput findCourseInput = new FindCourseInput(0);

        CourseOutput findCourseOutput = new CourseOutput();


        findCourseUseCase.execute(findCourseInput, findCourseOutput);
        
        assertThat(findCourseOutput.getSelectedCourseDTO(), equalTo(ObjectMother.createCourseDTO("OOAD")));
    }

}