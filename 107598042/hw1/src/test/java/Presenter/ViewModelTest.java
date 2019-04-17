package Presenter;

import TestUtility.ObjectMother;
import org.junit.Test;

import java.util.ArrayList;
import Domain.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ViewModelTest {
    @Test
    public void setSelectedCourse() {
        ViewModel viewModel = new ViewModel();
        Course course = Course.createCourse("OOAD");
        viewModel.setSelectedCourse(course);
        assertTrue(viewModel.getSelectedCourse().equals(course));
    }

    @Test
    public void setCourseList() {
        ViewModel viewModel = new ViewModel();
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList.add(ObjectMother.createCourse("OOAD"));
        viewModel.setCourseList(courseList);
        assertThat(viewModel.getCourseList(), contains(ObjectMother.createCourse("OOAD")));
    }
}