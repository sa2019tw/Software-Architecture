package Presenter;

import TestUtility.ObjectMother;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;
import UseCase.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JMock.class)
public class CoursePresenterTest {

    Mockery context = new JUnit4Mockery();


    // convert list of courseDTO to list of object which is the format of tableViewModel
    @Test
    public void convertCourseDTOToTableContentsOfView() {
        final CourseTableView DUMMY_VIEW = null;
        CoursePresenter coursePresenter = new CoursePresenter(DUMMY_VIEW);

        List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
        courseDTOList.add(ObjectMother.createCourseDTO("OOAD"));

        coursePresenter.setCourseDTOList(courseDTOList);


        coursePresenter.buildViewModel();


        ViewModel viewModel = coursePresenter.getViewModel();

        List<Object[]> tableContents = viewModel.getTableContent();

        assertEquals(tableContents.size(), 1);
//        assertThat(tableContents, hasSameContentsWith(courseDTOList));
    }


    @Test
    public void updateView() {
        final CourseTableView mockView = context.mock(CourseTableView.class);
        CoursePresenter coursePresenter = new CoursePresenter(mockView);

        context.checking(new Expectations() {{
            oneOf(mockView).updateTableView(with(any(ViewModel.class)));
        }});

        coursePresenter.updateView();
    }
}