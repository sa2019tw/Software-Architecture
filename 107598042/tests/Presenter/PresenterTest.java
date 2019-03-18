package Presenter;

import UseCase.CourseDTO;
import org.jmock.Expectations;
import org.junit.Test;
import TestUtility.ObjectMother;

import java.util.Collection;


import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class PresenterTest {

    Mockery context = new JUnit4Mockery();

    @Test
    public void selectCourseInCourseList() throws Exception {
        final int FIRST_COURSE = 0;
        Presenter presenter = ObjectMother.createPresenter();
        presenter.createNewCourse(ObjectMother.createCourseInputDAO("OOAD"));
        presenter.selectCourseDTOByRowIndex(FIRST_COURSE);
        assertThat(presenter.getSelectedCourseDTO(), equalTo(ObjectMother.createCourseDTO("OOAD")));
    }



    @Test
    public void fetchAllCourse() throws Exception {
        Presenter presenter = ObjectMother.createPresenterGivenDefaultTwoCourse();

        presenter.fetchAllCourse();
        assertThat(presenter.getCourseDTOCollection(), contains(ObjectMother.createCourseDTO("OOAD"),
                ObjectMother.createCourseDTO("POSD")));
    }


    @Test
    public void fetchCourseById() throws Exception {
        int POSD_COURSE_ID = 0;
        Presenter presenter = ObjectMother.createPresenter();

        presenter.createNewCourse(ObjectMother.createCourseInputDAO("POSD"));
        presenter.fetchCourseById(POSD_COURSE_ID);

        assertThat(presenter.getSelectedCourseDTO(), equalTo(ObjectMother.createCourseDTO("POSD")));
    }

    @Test
    public void deleteCourseFromExistCourse() throws Exception {
        final int SECOND_COURSE = 2;
        Presenter presenter = ObjectMother.createPresenter();

        presenter.createNewCourse(ObjectMother.createCourseInputDAO("OOAD"));
        presenter.createNewCourse(ObjectMother.createCourseInputDAO("POSD"));
        presenter.createNewCourse(ObjectMother.createCourseInputDAO("OOP"));

        presenter.deleteCourse(SECOND_COURSE);
        Collection<CourseDTO> courseDTOCollection = presenter.getCourseDTOCollection();

        assertThat(courseDTOCollection, hasItems(ObjectMother.createCourseDTO("OOAD"), ObjectMother.createCourseDTO("POSD")));
        assertThat(courseDTOCollection, not(hasItem(ObjectMother.createCourseDTO("OOP"))));
    }

    @Test
    public void modifyCourse() throws Exception {
        Presenter presenter = ObjectMother.createPresenter();
        presenter.createNewCourse(ObjectMother.createCourseInputDAO("OOAD"));

        presenter.modifyCourse(ObjectMother.createCourseInputDAO("STD"));

        assertThat(presenter.getCourseDTOCollection(), hasItem(ObjectMother.createCourseDTO("STD")));

    }

    @Test
    public void updateTableViewWhenCreateNewCourse() {
        Presenter presenter = ObjectMother.createPresenter();
        CourseTableView courseTableView = context.mock(CourseTableView.class);
        presenter.setView(courseTableView);
        presenter.setViewModel(new ViewModel());

        context.checking(new Expectations() {{
            oneOf(courseTableView).updateTableView(with(any(ViewModel.class)));
        }});

        presenter.createNewCourse(ObjectMother.createCourseInputDAO("OOAD"));
    }

    @Test
    public void createAddCourseWindowWhenInvokedOpenAddCourseWindow() {
        Presenter presenter = ObjectMother.createPresenter();
        ViewLoader mockViewLoader = context.mock(ViewLoader.class);
        presenter.setViewLoader(mockViewLoader);

        context.checking(new Expectations() {{
            oneOf(mockViewLoader).createAddCourseWindow(with(any(Presenter.class)));
        }});

        presenter.invokedOpenAddCourseWindow();
    }

    @Test
    public void createEditCourseWindowWhenInvokedOpenEditCourseWindow() {
        Presenter presenter = ObjectMother.createPresenter();
        ViewLoader mockViewLoader = context.mock(ViewLoader.class);
        presenter.setViewLoader(mockViewLoader);
        final int SELECTED_ROW = 0;

        context.checking(new Expectations() {{
            oneOf(mockViewLoader).createEditCourseWindow(with(any(Presenter.class)));
        }});

        presenter.invokedOpenEditCourseWindowGiven(SELECTED_ROW);
    }


//    @Test
//    public void buildViewModelGivenCourseList() throws Exception {
//        Presenter presenter = ObjectMother.createPresenter();
//        ViewModel viewModel = new ViewModel();
//        presenter.setViewModel(viewModel);
//        presenter.createNewCourse(ObjectMother.createCourseInputDAO("OOAD"));
//        assertThat(viewModel.getCourseCollection(), hasItem(ObjectMother.createCourseDTO("OOAD")));
//    }

//    @Test
//    public void buildViewModelGivenSelectedCourse() throws Exception {
//        Presenter presenter = ObjectMother.createPresenter();
//        ViewModel viewModel = new ViewModel();
//        presenter.setViewModel(viewModel);
//        presenter.createNewCourse(ObjectMother.createCourseInputDAO("OOAD"));
//        presenter.fetchCourseById(0);
//        assertThat(viewModel.getSelectedCourse(), equalTo(ObjectMother.createCourse("OOAD")));
//    }

}