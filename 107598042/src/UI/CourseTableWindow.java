package UI;


import Presenter.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class CourseTableWindow extends JFrame {
    private Presenter presenter;
    JTable table = new JTable();
    CourseTableModel courseTableModel = new CourseTableModel();
    int selectedRowIndex = -1;

    JScrollPane createJScrollPane() {
        initializeJTable();
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }

    private void initializePresenter(Presenter presenter) {
        this.presenter = presenter;
        this.presenter.setView(courseTableModel);
    }

    private void initializeWidgetComponent() {
        this.add(createJScrollPane());
        this.add(createFetchAllCourseButton());
        this.add(createOpenAddCourseWindowButton());
        this.add(createDeleteRowButton());
        this.add(createOpenEditCourseWindowButton());
        this.setLayout(new FlowLayout());

    }

    private void initializeTableListener() {
        ListSelectionModel model = table.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    updateSelectedRowIndex(model);
                }
            }
        });
    }

    private void updateSelectedRowIndex(ListSelectionModel  model) {
        selectedRowIndex = model.getMinSelectionIndex();
    }

    private int fetchSelectedCourseIdentifier() {
        return (int)courseTableModel.getValueAt(selectedRowIndex, 0);
    }

    private void initializeWindowLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 400);
        this.setVisible(true);
        this.setTitle("My First Swing Java App");
    }

    public CourseTableWindow(Presenter presenter) {

        this.initializePresenter(presenter);

        this.initializeWidgetComponent();

        this.initializeTableListener();

        this.initializeWindowLayout();

    }

    private JButton createOpenEditCourseWindowButton() {
        return createButtonGivenActionListener("Edit Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRowSelected())
                    return;

                presenter.invokedOpenEditCourseWindowGiven(selectedRowIndex);
            }

        });
    }


    private boolean isRowSelected() {
        return fetchSelectedCourseIdentifier() != -1;
    }

    private JButton createDeleteRowButton() {
        return createButtonGivenActionListener("Delete By Id", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRowSelected())
                    return;

                presenter.deleteCourse(fetchSelectedCourseIdentifier());
            }
        });
    }

    private JButton createButtonGivenActionListener(String buttonText, ActionListener listener) {
        JButton button = createJButton(buttonText);
        button.addActionListener(listener);
        return button;
    }

    private JButton createFetchAllCourseButton() {
        return createButtonGivenActionListener("Fetch All Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.fetchAllCourse();
            }
        });
    }

    private JButton createOpenAddCourseWindowButton() {
        return createButtonGivenActionListener("Add Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.invokedOpenAddCourseWindow();
            }
        });
    }

    private JButton createJButton(String buttonText) {
        return new JButton(buttonText);
    }

    private void initializeJTable() {
        table.setModel(courseTableModel);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        table.setRowHeight(30);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
    }
}
