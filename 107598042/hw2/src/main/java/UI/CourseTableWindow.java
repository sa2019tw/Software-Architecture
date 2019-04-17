package UI;


import Presenter.*;
import UseCase.DeleteCourse.DeleteCourseInput;
import UseCase.FindAllCourse.FindAllCourseInput;
import UseCase.FindCourse.FindCourseInput;
import UseCase.UseCaseFacade;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CourseTableWindow extends JFrame {
    private UseCaseFacade useCaseFacade;
    JTable table = new JTable();
    CourseTableModel courseTableModel = new CourseTableModel();
    int selectedRowIndex = -1;
    private CoursePresenter coursePresenter;

    JScrollPane createJScrollPane() {
        initializeJTable();
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }

    private void initializePresenter(CoursePresenter presenter) {
        this.coursePresenter = presenter;
        this.coursePresenter.registerView(courseTableModel);
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
        final ListSelectionModel model = table.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
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

    private Object fetchSelectedCourseIdentifier() {
        return courseTableModel.getValueAt
                (selectedRowIndex, 0);
    }

    private void initializeWindowLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 400);
        this.setVisible(true);
        this.setTitle("My First Swing Java App");
    }

    public CourseTableWindow(CoursePresenter coursePresenter, UseCaseFacade useCaseFacade) {
        this.initializePresenter(coursePresenter);

        this.initializeWidgetComponent();

        this.initializeTableListener();

        this.initializeWindowLayout();

        this.useCaseFacade = useCaseFacade;

    }

    private JButton createOpenEditCourseWindowButton() {
        return createButtonGivenActionListener("Edit Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRowSelected())
                    return;

                useCaseFacade.executeFindCourseUseCase(new FindCourseInput((Integer) fetchSelectedCourseIdentifier()), coursePresenter);

                coursePresenter.invokedOpenEditCourseWindowGiven(selectedRowIndex, useCaseFacade);
            }

        });
    }


    private boolean isRowSelected() {
        return (Integer) fetchSelectedCourseIdentifier() != -1;
    }

    private JButton createDeleteRowButton() {
        return createButtonGivenActionListener("Delete By Id", new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!isRowSelected())
                    return;

                useCaseFacade.executeDeleteCourseUseCase(new DeleteCourseInput((Integer) fetchSelectedCourseIdentifier()), coursePresenter);
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
                useCaseFacade.executeFindAllCourseUseCase(new FindAllCourseInput(), coursePresenter);

            }
        });
    }

    private JButton createOpenAddCourseWindowButton() {
        return createButtonGivenActionListener("Add Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coursePresenter.invokedOpenAddCourseWindow(useCaseFacade);
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
