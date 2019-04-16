package UseCase.AddCourse;

import Domain.CourseBase;
import Gateway.InMemoryCourseBase;

import TestUtility.ObjectMother;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class AddCourseUseCaseTest {

    @Test
    public void addCourse() {
        CourseBase courseBase = new InMemoryCourseBase();
        AddCourseUseCase addCourseUseCase = new AddCourseUseCase(courseBase);

        AddCourseInput input = new AddCourseInput("OOAD",
                "This course is about software tesing",
                "Freshman only",
                "None",
                "Programmer",
                1999.0);

        AddCourseOutput output = new AddCourseOutput();

        addCourseUseCase.execute(input, output);

        assertThat(output.getCourseDTO(), equalTo(ObjectMother.createCourseDTO("OOAD")));
    }

}