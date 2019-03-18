package UseCase;

import Domain.*;
import Domain.OutputBoundary.OutputBoundary;
import Presenter.CourseInputDTO;
import TestUtility.ObjectMother;
import org.jmock.Expectations;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class UseCaseTest {

    Mockery context = new JUnit4Mockery();

    @Test
    public void fetchAllCourseAndTransformResultToDTO() {
        CourseBase mockCourseBase = ObjectMother.createCourseBase();
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(mockCourseBase);

        Collection<CourseDTO> courseDTOCollection = useCase.fetchAllCourseDTO();

        assertThat(courseDTOCollection, contains(ObjectMother.createCourseDTO("OOAD"), ObjectMother.createCourseDTO("POSD")));
    }

    @Test
    public void sendDTOCollectionAcrossOutputBoundaryWhenFetchAllCourse() {
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(new CourseBaseStub());
        OutputBoundary mockOutputBoundary = context.mock(OutputBoundary.class);
        useCase.setOutputBoundary(mockOutputBoundary);

        Collection<CourseDTO> courseDTOCollection = new ArrayList<CourseDTO>();

        context.checking(new Expectations() {{
            oneOf(mockOutputBoundary).setCourseDTOCollection(courseDTOCollection);
        }});

        useCase.fetchAllCourses();
    }

    @Test
    public void fetchCourseByIdAndTransformResultToDTO() {
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(ObjectMother.createCourseBase());
        final int identifier = 0;

        CourseDTO courseDTO = useCase.fetchCourseById(identifier);

        assertThat(courseDTO, equalTo(ObjectMother.createCourseDTO("OOAD")));
    }

    @Test
    public void sendDTOAcrossBoundaryWhenFetchCourseById() {
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(new CourseBaseStub());
        OutputBoundary mockOutputBoundary = context.mock(OutputBoundary.class);
        useCase.setOutputBoundary(mockOutputBoundary);


        context.checking(new Expectations() {{
            oneOf(mockOutputBoundary).setCourseDTO(with(any(CourseDTO.class)));
        }});

        useCase.fetchCourseById(0);
    }

    @Test
    public void deleteCourseByIdDTO() {
        final int OOAD_COURSE_ID = 0;
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(ObjectMother.createCourseBase());


        Collection<CourseDTO> courseDTOCollection = useCase.fetchAllCourseDTO();
        assertThat(courseDTOCollection, hasItem(ObjectMother.createCourseDTO("OOAD")));

        useCase.deleteCourseById(OOAD_COURSE_ID);
        courseDTOCollection = useCase.fetchAllCourseDTO();

        assertThat(courseDTOCollection, not(hasItem(ObjectMother.createCourseDTO("OOAD"))));
    }

    @Test // has some expression problem
    public void sendDTOCollectionAcrossBoundaryWhenDeleteCourseById() {
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(new CourseBaseStub());
        OutputBoundary mockOutputBoundary = context.mock(OutputBoundary.class);
        useCase.setOutputBoundary(mockOutputBoundary);

        Collection<CourseDTO> courseDTOCollection = new ArrayList<CourseDTO>();

        context.checking(new Expectations() {{
            allowing(mockOutputBoundary).setCourseDTOCollection(courseDTOCollection);
        }});

        useCase.deleteCourseById(0);
    }


    @Test
    public void createNewCourseDTO() {
        final int OS_ID = 2;
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(ObjectMother.createCourseBase());

        useCase.createCourse(ObjectMother.createCourseInputDAO("OS"));

        CourseDTO courseDTO = useCase.fetchCourseById(OS_ID);
        assertThat(courseDTO, equalTo(ObjectMother.createCourseDTO("OS")));
    }

    @Test //  has some expression problem
    public void sendDTOCollectionsAcrossBoundaryWhenCreateCourse() {
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(new CourseBaseStub());
        OutputBoundary mockOutputBoundary = context.mock(OutputBoundary.class);
        useCase.setOutputBoundary(mockOutputBoundary);
        Collection<CourseDTO> courseDTOCollection = new ArrayList<CourseDTO>();


        context.checking(new Expectations() {{
            allowing(mockOutputBoundary).setCourseDTOCollection(courseDTOCollection);
        }});

        useCase.createCourse(ObjectMother.createCourseInputDAO("OOAD"));
    }

    @Test
    public void modifyCourse() {
        int MODIFY_COURSE_ID = 0;
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(ObjectMother.createCourseBase());


        useCase.modifyCourse(ObjectMother.createCourseInputDAO("modify course"));

        CourseDTO courseDTO = useCase.fetchCourseById(MODIFY_COURSE_ID);

        assertThat(courseDTO, equalTo(ObjectMother.createCourseDTO("modify course")));
    }

    @Test
    public void sendDTOCollectionAcrossBoundaryWhenModifyCourse() {
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(new CourseBaseStub());
        OutputBoundary mockOutputBoundary = context.mock(OutputBoundary.class);
        useCase.setOutputBoundary(mockOutputBoundary);

        Collection<CourseDTO> courseDTOCollection = new ArrayList<CourseDTO>();


        context.checking(new Expectations() {{
            allowing(mockOutputBoundary).setCourseDTOCollection(courseDTOCollection);
        }});

        useCase.modifyCourse(ObjectMother.createCourseInputDAO("OOAD"));
    }

    private class CourseBaseStub implements CourseBase {
        @Override
        public void createNewCourse(Course course) {

        }

        @Override
        public Course fetchCourseById(int id) {
            return null;
        }

        @Override
        public ArrayList<Course> fetchAllCourse() {
            ArrayList<Course> courseList = new ArrayList<Course>();
            return courseList;
        }

        @Override
        public void modifyExistCourseById(int id, Course course) {

        }

        @Override
        public void deleteCourseById(int id) {

        }
    }

    @Test
    public void transformCourseInputDAOIntoCourseEntity() {
        final CourseBase EMPTY_COURSE_BASE = null;
        CourseManageUseCase useCase = ObjectMother.createCRUDCourseUseCase(EMPTY_COURSE_BASE);
        CourseInputDTO courseInputDAO = ObjectMother.createCourseInputDAO("OOAD");
        Course transformedCourse = useCase.transformDAOIntoCourseEntity(courseInputDAO);
        assertThat(transformedCourse, equalTo(ObjectMother.createCourse("OOAD")));
    }
}


