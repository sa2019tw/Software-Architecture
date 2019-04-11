package UI;

import Domain.Course;
import Presenter.*;
import UseCase.CourseDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CourseTableModel extends DefaultTableModel implements CourseTableView {

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
        List<Object[]> tableContents = viewModel.getTableContent();

        for (int i = 0; i < tableContents.size(); i++) {
            this.addRow(tableContents.get(i));
        }
    }

}
