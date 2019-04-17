package Presenter;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CourseInputDTOTest {
    @Test
    public void CourseInputDAO() {
        String courseName = "OOAD";
        String description = "This is a description";
        String notes = "None";
        String remark = "None";
        String suitableObject = "programmer";
        int price = 1999;

        CourseInputDTO courseInputDAO = new CourseInputDTO(courseName, description, notes, remark, suitableObject, price);
        assertThat(courseInputDAO.courseName, equalTo("OOAD"));
        assertThat(courseInputDAO.description, equalTo("This is a description"));
        assertThat(courseInputDAO.notes, equalTo("None"));
        assertThat(courseInputDAO.remark, equalTo("None"));
        assertThat(courseInputDAO.suitableObject, equalTo("programmer"));
        assertThat(courseInputDAO.price, equalTo(1999));
    }
}