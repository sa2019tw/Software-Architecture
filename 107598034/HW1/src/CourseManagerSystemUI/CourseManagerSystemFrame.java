package CourseManagerSystemUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import CourseManagerSystemUseCase.CourseManagerSystem;
import entities.Courses;

public class CourseManagerSystemFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	CourseManagerSystem courseManagerSystem = new CourseManagerSystem();
	Map<String, Courses> courseMap = new TreeMap<String, Courses>();
	String[] buttonName = {"NewCourse", "AddNewCourse", "EditCourse", "DeleteCourse"};
	JButton[] buttonArr = new JButton[buttonName.length];
	String[] courseLabelName = {"課程名稱*", "課程說明", "適合對象", "定價", "注意事項", "備註"};
	String[] courseColumn = {"課程名稱", "課程說明", "適合對象", "定價", "注意事項", "備註"};
	JLabel[] labelArr = new JLabel[courseLabelName.length];
	JTextField[] textFieldArr = new JTextField[courseLabelName.length];
	JPanel[] panel = new JPanel[4];
	JPanel[] flowPanel = new JPanel[2];
	JTable courseTable = new JTable();
	Object[][] loadFileToTableData;
	Object[] tableRow = new Object[courseColumn.length];
	DefaultTableModel model;
	int btn;

	public CourseManagerSystemFrame() throws IOException {
		super("課程系統");
		
		FileReader fr = null;
		try {
			fr = new FileReader("src/courseList");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(fr);
		String readLine = br.readLine();
		
		try {
			courseMap = courseManagerSystem.loadJsonFileToCourseMap(readLine);
			loadFileToTableData = new Object[courseMap.keySet().size()][courseLabelName.length];
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ButtonHandler handler = new ButtonHandler();
		for (int i = 0;i<buttonName.length;i++) {
			buttonArr[i] = new JButton(buttonName[i]);
			buttonArr[i].addActionListener(handler);
		}
		
		courseTable.addMouseListener(new MouseAdapter());
		
		for (int i = 0; i < courseLabelName.length; i++) {
			labelArr[i] = new JLabel(courseLabelName[i]);
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
		for (int i = 0 ;i < courseLabelName.length; i++) {
			panel[2].add(labelArr[i]);
			panel[2].add(textFieldArr[i]);
		}
		
		loadFileToTableData = showCourseTable(courseMap);
		
		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
			    return false;
			   }   
		};
		
        model.setColumnIdentifiers(courseColumn);
        for(int i = 0; i < loadFileToTableData.length; i++) {
        	model.addRow(loadFileToTableData[i]);
        }
        
        courseTable.setModel(model);
        JScrollPane pane = new JScrollPane(courseTable);
		pane.setBounds(0, 0, 1000, 600);
		
		panel[0].setLayout(new GridLayout(3,1,3,3));
		panel[0].add(pane);
		panel[0].add(panel[2]);
		panel[0].add(panel[1]);
		
		add(panel[0]);
	}
	
	public Object[][] showCourseTable(Map<String, Courses> courseMap) {
			Object[][] tableData = new Object[courseMap.keySet().size()][courseLabelName.length];
		int index = 0;
		for (String key : courseMap.keySet()) {
		    Courses course = courseMap.get(key);
		    tableData[index][0] = course.getCourseName();
		    tableData[index][1] = course.getCourseDescription();
		    tableData[index][2] = course.getSuitable();
		    tableData[index][3] = course.getPrice();
		    tableData[index][4] = course.getPrecautions();
		    tableData[index][5] = course.getNote();
		    index++;
		}
		return tableData;
	}

	public class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttonArr.length; i++) {
				if (e.getSource()==buttonArr[i]) {
					btn=i;
					switch(i) {
						default:
						case 0: //NewCourse
							for(int j = 0;j<textFieldArr.length;j++)
								textFieldArr[j].setText("");
							break;
						case 1: //AddNewCourse
							if(!textFieldArr[0].getText().equals("") && !textFieldArr[0].getText().toString().trim().equals("")) {
								if(!courseMap.containsKey(textFieldArr[0].getText().toString())) {
									for(int j = 0; j < tableRow.length; j++) {
										tableRow[j] = textFieldArr[j].getText();
									}
									model.addRow(tableRow);
								}
								
								Courses c = new Courses(
										textFieldArr[0].getText(),
										textFieldArr[1].getText(),
										textFieldArr[2].getText(),
										parseWithDefault(textFieldArr[3].getText().toString(), 0),
										textFieldArr[4].getText(),
										textFieldArr[5].getText());
								courseMap = courseManagerSystem.addNewCourse(c);
								try {
									courseManagerSystem.saveCourseToFile();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}else {
								JOptionPane.showMessageDialog(null, "課程名稱為必要輸入");
								break;
							}
							break;
						case 2: //EditCourse
							if(!textFieldArr[0].getText().equals("")) {
								int chooseCourse = courseTable.getSelectedRow();
				                
				                if(chooseCourse >= 0) {
				                	for(int j = 0; j < textFieldArr.length; j++) {
				                		model.setValueAt(textFieldArr[j].getText(), chooseCourse, j);
				                	}
				                }
				                
								Courses c = new Courses(textFieldArr[0].getText(),
									textFieldArr[1].getText(),
									textFieldArr[2].getText(),
									parseWithDefault(textFieldArr[3].getText().toString(), 0),
									textFieldArr[4].getText(),
									textFieldArr[5].getText());
								courseMap = courseManagerSystem.editCourse(c);
								try {
									courseManagerSystem.saveCourseToFile();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}else {
								JOptionPane.showMessageDialog(null, "課程名稱為必要輸入");
								break;
							}
							break;
						case 3: //DeleteCourse
							int choooseRow = courseTable.getSelectedRow();
							int column = 0;
							String deleteCourseName = "";
							
				            if(choooseRow >= 0){
				               deleteCourseName = courseTable.getModel().getValueAt(choooseRow , column).toString();
				               model.removeRow(choooseRow);
				            } else {
				            	System.out.println("Delete Error");
				            }
				            
							courseMap = courseManagerSystem.deleteCourse(deleteCourseName);
							try {
								courseManagerSystem.saveCourseToFile();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							for(int j = 0;j<textFieldArr.length;j++)
								textFieldArr[j].setText("");
							break;
					}//end of switch
				}//end of if-else
			}//end of for-loop
		}//end of actionPerformed
	}//end of ButtonHandler

	public class MouseAdapter implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			 // i = the index of the selected row
            int chooseCourse = courseTable.getSelectedRow();
            for(int i = 0; i < textFieldArr.length; i++) {
            	textFieldArr[i].setText(model.getValueAt(chooseCourse, i).toString());
            }
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
	
	private int parseWithDefault(String s, int def) {
	    try {
	        return Integer.parseInt(s);
	    }
	    catch (NumberFormatException e) {
	        // It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
	        return def;
	    }
	}
}
