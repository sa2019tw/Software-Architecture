package UI;

import Domain.Course;
import Presenter.*;
import UseCase.CourseDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class CourseTableModel extends DefaultTableModel implements CourseTableView {

    //ArrayList<Course> courseArrayList  = new ArrayList<Course>();
    //Course selectedCourse;
    Collection<CourseDTO> courseDTOCollection = new ArrayList<CourseDTO>();
    CourseDTO selectedCourseDTO;

    String[] columnIdentifiers = new String[] { "id", "courseName", "description", "notes", "remark", "suitableObject", "price" };

    public CourseTableModel() {
        this.setColumnIdentifiers(columnIdentifiers);
    }


    public void updateTableView(ViewModel viewModel) {
        cleanTableModelContent();
        updateTableModelData(viewModel);
    }

    private void cleanTableModelContent() {
        this.setRowCount(0);
    }

    private void updateTableModelData(ViewModel viewModel) {
        courseDTOCollection = viewModel.getCourseCollection();

        Iterator<CourseDTO> courseDTOIterator =  courseDTOCollection.iterator();

        while (courseDTOIterator.hasNext()) {
             CourseDTO courseDTO = courseDTOIterator.next();
             this.addRow(new Object[] { courseDTO.id, courseDTO.courseName, courseDTO.description,
                     courseDTO.notes, courseDTO.remark, courseDTO.suitableObject,
                     courseDTO.price});
        }


        selectedCourseDTO = viewModel.getSelectedCourseDTO();
    }

}
