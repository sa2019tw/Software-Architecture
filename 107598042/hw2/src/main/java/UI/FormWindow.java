package UI;


import Presenter.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public abstract class FormWindow extends JFrame {
    protected CoursePresenter coursePresenter;
    Hashtable<String, Component> fieldHashtable = new Hashtable<String, Component>();

    JTextField courseNameTextField = createJField("Type Here");
    JTextField notesTextField = createJField("Type Here");
    JTextField remarkTextField = createJField("Type Here");
    JTextField suitableObjectTextField = createJField("Type Here");
    JTextField priceField = createJField("Type Here");
    int selectedCourseIdentifier = -1;
    JTextArea descriptionArea = createTextArea();

    private void initializeTextField() {
        fieldHashtable.put("Course Name", courseNameTextField);
        fieldHashtable.put("Description", descriptionArea);
        fieldHashtable.put("Notes", notesTextField);
        fieldHashtable.put("Remark", remarkTextField);
        fieldHashtable.put("SuitableObject", suitableObjectTextField);
        fieldHashtable.put("Price", priceField);
    }


    public FormWindow(CoursePresenter coursePresenter) {
        this.initializeWindowLayout();
        this.initializeTextField();
        this.initializeJPanel();
        this.coursePresenter = coursePresenter;
    }


    private void initializeWindowLayout() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 400);
        this.setVisible(true);
        this.setTitle("Add Course Window");
    }

    private void initializeJPanel() {
        JPanel panel = createJPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(createRowPanelGivenLabelNameAndTextFieldName("Course Name", "Type Here"));
        panel.add(createRowPanelGivenLabelNameAndTextFieldName("Description", "Type Here"));
        panel.add(createRowPanelGivenLabelNameAndTextFieldName("Notes", "Type Here"));
        panel.add(createRowPanelGivenLabelNameAndTextFieldName("Remark", "Type Here"));
        panel.add(createRowPanelGivenLabelNameAndTextFieldName("SuitableObject", "Type Here"));
        panel.add(createRowPanelGivenLabelNameAndTextFieldName("Price", "Type Here"));
        panel.add(createEditCourseButton());
        panel.add(createCloseAddCourseWindowButton());
        this.add(panel);
    }

    private JPanel createJPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    abstract String actionButtonName();

    public JButton createEditCourseButton() {
        return createJButtonGivenListener(actionButtonName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameTextField.getText();
                String description = descriptionArea.getText();
                String notes = notesTextField.getText();
                String remark = remarkTextField.getText();
                String suitableObject = suitableObjectTextField.getText();
                int price = Integer.parseInt(priceField.getText());
                CourseInputDTO courseInputDAO = new CourseInputDTO(courseName, description, notes, remark, suitableObject, price);
                courseInputDAO.setId(selectedCourseIdentifier);



                invokeAction(courseInputDAO);
                dispose();
            }
        });
    }

    abstract void invokeAction(CourseInputDTO courseInputDAO);

    public JButton createCloseAddCourseWindowButton() {
        return createJButtonGivenListener("Cancel", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public JPanel createRowPanelGivenLabelNameAndTextFieldName(String labelName, String fieldName) {
        JPanel panel =  createJPanel();
        panel.setSize(200, 30);
        panel.add(createJLabel(labelName));
        panel.add(fieldHashtable.get(labelName));
        return panel;
    }

    public JLabel createJLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        return label;
    }

    public JButton createJButtonGivenListener(String buttonText, ActionListener listener) {
        JButton button = new JButton(buttonText);
        button.addActionListener(listener);
        return button;
    }

    public JTextField createJField(String fieldText) {
        JTextField field = new JTextField(fieldText);
        return field;
    }

    private JTextArea createTextArea() {
        JTextArea textArea1 = new JTextArea(10, 15);
        textArea1.setText("Just a whole bunch of text that is important\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        return textArea1;
    }

}
