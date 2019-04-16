package UseCase.UpdateCourse;

import Domain.Course;
import Domain.CourseBase;
import TestUtility.ObjectMother;
import UseCase.CourseDTO;
import UseCase.CourseDTOMapper;
import UseCase.CourseOutput;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class UpdateCourseUseCaseTest {

    @Test
    public void updateCourse() {
        CourseBase courseBase = ObjectMother.createCourseBaseGivenDefaultTwoCourse();
        UpdateCourseUseCase updateCourseUseCase = new UpdateCourseUseCase(courseBase);


        CourseDTO updateCourseDTO = ObjectMother.createCourseDTO("OOP");

        UpdateCourseInput updateCourseInput = new UpdateCourseInput(0, updateCourseDTO);

        CourseOutput updateCourseOutput = new CourseOutput();

        updateCourseUseCase.execute(updateCourseInput, updateCourseOutput);

        Course course = courseBase.fetchCourseById(0);
        CourseDTO courseDTO = new CourseDTOMapper().mappingCourseDomainToCourseDTO(course);

        assertThat(courseDTO, equalTo(updateCourseDTO));
    }


}