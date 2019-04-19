package Presenter;

import Domain.Course;
import UseCase.CourseDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ViewModel {
//
//    private CourseDTO selectedCourseDTO;
//    private Collection<CourseDTO> courseCollection = new ArrayList<CourseDTO>();
//
    private List<Object[]> tableContents;

    public List<Object[]> getTableContent() {
        return tableContents;
    }

    public void setTableContent(List<Object[]> tableContents) {
        this.tableContents = tableContents;
    }
}
