package CourseManagerSystemUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Adapter.Controller.AddCourse.AddCourseController;
import Adapter.Controller.DeleteCourse.DeleteCourseController;
import Adapter.Controller.EditCourse.EditCourseController;
import Adapter.Controller.getAllCourse.GetAllCourseController;
import Adapter.Presenter.AddCoursePresenter;
import Adapter.Presenter.GetAllCoursePresenter;


public class CourseManagerSystemFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] buttonName = {"NewCourse", "AddNewCourse", "EditCourse", "DeleteCourse"};
	JButton[] buttonArr = new JButton[buttonName.length];
	String[] courseLabelName = {"課程編號", "課程名稱*", "課程說明", "適合對象", "定價", "注意事項", "備註"};
	String[] courseColumn = {"課程名稱", "課程說明", "適合對象", "定價", "注意事項", "備註"};
	JLabel[] labelArr = new JLabel[courseColumn.length];
	JTextField[] textFieldArr = new JTextField[courseColumn.length];
	JPanel[] panel = new JPanel[4];
	JPanel[] flowPanel = new JPanel[2];
	JTable courseTable = new JTable();
	Object[][] loadFileToTableData;
	
	DefaultTableModel model;
	int btn;
	
	AddCourseController addCourseController;
	EditCourseController editCourseController;
	DeleteCourseController deleteCourseController;
	GetAllCourseController getAllCoursecontroller;
	GetAllCoursePresenter getAllCoursePresenter;
	AddCoursePresenter addCoursePresenter;

	public CourseManagerSystemFrame() {
		super();
		getAllCoursecontroller = new GetAllCourseController();
		getAllCoursecontroller.getAllCourse();
		getAllCoursePresenter = new GetAllCoursePresenter();
		loadFileToTableData = getAllCoursePresenter.getAllCourseInJson();
		
		for (int i = 0;i<buttonName.length;i++) {
			buttonArr[i] = new JButton(buttonName[i]);
		}
		
		NewCourseButtonHandler NewCoursehandler = new NewCourseButtonHandler();
		AddNewCourseButtonHandler AddNewCoursehandler = new AddNewCourseButtonHandler();
		EditCourseButtonHandler editCoursehandler = new EditCourseButtonHandler();
		DeleteCourseButtonHandler deleteCoursehandler = new DeleteCourseButtonHandler();
		
		buttonArr[0].addActionListener(NewCoursehandler);
		buttonArr[1].addActionListener(AddNewCoursehandler);
		buttonArr[2].addActionListener(editCoursehandler);
		buttonArr[3].addActionListener(deleteCoursehandler);
		
		
		courseTable.addMouseListener(new MouseAdapter());
		
		for (int i = 0; i < courseColumn.length; i++) {
			labelArr[i] = new JLabel(courseColumn[i]);
		}
		
		for (int i = 0; i < textFieldArr.length; i++) {
			textFieldArr[i] = new JTextField(20);
		}
		
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
			
		panel[1].setLayout(new GridLayout(1,4,5,5));
		panel[1].add(buttonArr[0]);
		panel[1].add(buttonArr[1]);
		panel[1].add(buttonArr[2]);
		panel[1].add(buttonArr[3]);
		
		
		panel[2].setLayout(new GridLayout(6,3,5,5));
		for (int i = 0 ;i < courseColumn.length; i++) {
			panel[2].add(labelArr[i]);
			panel[2].add(textFieldArr[i]);
		}
				
		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
			    return false;
			}   
		};
		
        model.setColumnIdentifiers(courseLabelName);
        for(int i = 0; i < loadFileToTableData.length; i++) {
        	model.addRow(loadFileToTableData[i]);
        }
        
        courseTable.setModel(model);
        TableColumn tcol = courseTable.getColumnModel().getColumn(0);
        courseTable.getColumnModel().removeColumn(tcol);
        JScrollPane pane = new JScrollPane(courseTable);
		pane.setBounds(0, 0, 1000, 600);
		
		panel[0].setLayout(new GridLayout(3,1,3,3));
		panel[0].add(pane);
		panel[0].add(panel[2]);
		panel[0].add(panel[1]);
		
		add(panel[0]);
	}
	
	public class NewCourseButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonArr[0]) {
				for(int j = 0;j<textFieldArr.length;j++)
					textFieldArr[j].setText("");
			}
		}
	}
	
	public class AddNewCourseButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonArr[1]) {
				addCourseController = new AddCourseController();
				Object[] addTableRow = new Object[courseLabelName.length];
				if(!textFieldArr[0].getText().equals("") && !textFieldArr[0].getText().toString().trim().equals("")) {
					if(!(textFieldArr[0].getText().toString()).equals("")) {
						addTableRow[0] = "";
						for(int j = 0; j < textFieldArr.length; j++) {
							addTableRow[j+1] = textFieldArr[j].getText();
						}
						addCourseController.addCourse(addTableRow);
						loadFileToTableData = getAllCoursePresenter.getAllCourseInJson();	
						addTableRow[0] = loadFileToTableData[loadFileToTableData.length - 1][0];
						model.addRow(addTableRow);
					}
				}else {
					JOptionPane.showMessageDialog(null, "課程名稱為必要輸入");
				}
				for(int j = 0;j<textFieldArr.length;j++)
					textFieldArr[j].setText("");
			}
		}
	}
	
	public class EditCourseButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] editTableRow = new Object[courseLabelName.length];
			if (e.getSource() == buttonArr[2]) {
				editCourseController = new EditCourseController();
				if(!textFieldArr[0].getText().equals("")) {
					int chooseCourse = courseTable.getSelectedRow();
	                if(chooseCourse >= 0) {
	                	editTableRow[0] = model.getValueAt(chooseCourse, 0);
	                	for(int j = 0; j < textFieldArr.length; j++) {
	                		editTableRow[j+1] = textFieldArr[j].getText();
	                		model.setValueAt(textFieldArr[j].getText(), chooseCourse, j + 1);
	    				}
	                	editCourseController.editCourse(editTableRow);
	                	
	                }
				}else {
					JOptionPane.showMessageDialog(null, "課程名稱為必要輸入");
				}
			}
		}
	}
	
	public class DeleteCourseButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] deleteTableRow = new Object[courseLabelName.length];
			if (e.getSource() == buttonArr[3]) {
				deleteCourseController = new DeleteCourseController();
				int choooseRow = courseTable.getSelectedRow();
	            if(choooseRow >= 0){
	            	for(int j = 0; j < deleteTableRow.length; j++) {
						deleteTableRow[j] = model.getValueAt(choooseRow, j);
					}
	               model.removeRow(choooseRow);
	            } else {
	            	System.out.println("Delete Error");
	            }
	            
				for(int j = 0;j<textFieldArr.length;j++)
					textFieldArr[j].setText("");
				deleteCourseController.deleteCourse(deleteTableRow);
			}	
		}
	}

	public class MouseAdapter implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
            int chooseCourse = courseTable.getSelectedRow();
            textFieldArr[0].setText(model.getValueAt(chooseCourse, 1).toString());
            textFieldArr[1].setText(model.getValueAt(chooseCourse, 2).toString());
            textFieldArr[2].setText(model.getValueAt(chooseCourse, 3).toString());
            textFieldArr[3].setText(model.getValueAt(chooseCourse, 4).toString());
            textFieldArr[4].setText(model.getValueAt(chooseCourse, 5).toString());
            textFieldArr[5].setText(model.getValueAt(chooseCourse, 6).toString());
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {	}
	}

}
