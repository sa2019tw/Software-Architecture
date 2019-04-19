package main.UI;
import main.control.AddCourseControler;
import main.control.DeleteControler;
import main.control.EditControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ManageCourseView extends JFrame implements ActionListener {
    private String[] courseName = {"課程名稱*", "課程說明", "適合對象", "定價", "注意事項", "備註"};
    private String[] buttonName = {"新增", "修改", "刪除", "顯示"};
    private JButton[] btn = new JButton[buttonName.length];
    private JTextField[] textField = new JTextField[courseName.length];
    private JPanel[] panel = new JPanel[4];
    private Container CP = getContentPane();
    private JLabel[] label = new JLabel[courseName.length];

    public ManageCourseView() {
        CP.setLayout(null);
        for (int i = 0; i < courseName.length; i++) {
            label[i] = new JLabel(courseName[i]);
            label[i].setBounds(20, 20 + i * 40, 65, 25);
            CP.add(label[i]);
        }
        for (int i = 0; i < buttonName.length; i++) {
            btn[i] = new JButton(buttonName[i]);
            btn[i].addActionListener(this);
            this.add(btn[i], buttonName[i]);
            btn[i].setBounds(20 + 100 * i, 260, 100, 25);
            CP.add(btn[i]);
        }
        for (int i = 0; i < textField.length; i++) {
            textField[i] = new JTextField(20);
            textField[i].setBounds(85, 20 + 40 * i, 100, 25);
            CP.add(textField[i]);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        JFrame f = null;
        for (int k = 0; k < btn.length; k++) {
            if (e.getSource() == btn[k]) {
                if (k == 0) {
                    try {
                        if(textField[3].getText().equals("")){textField[3].setText("0");}
                        AddCourseControler addCourseControler = new AddCourseControler(textField[0].getText(), textField[1].getText(), textField[2].getText(), Integer.parseInt(textField[3].getText()), textField[4].getText(), textField[5].getText());
                        addCourseControler.exc();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    for (int i = 0; i < textField.length; i++) {

                        textField[i].setText("");//clear
                    }
                    break;
                }
                if(k==1)
                {
                    String courseName=JOptionPane.showInputDialog("輸入你要修改課程名稱");
                    if(!courseName.equals(""))
                    {
                        String courseDescription=JOptionPane.showInputDialog("輸入你要修改課程說明");
                        String applicableObject=JOptionPane.showInputDialog("輸入你要修改適合對象");
                        int price=Integer.parseInt(JOptionPane.showInputDialog("輸入你要修改定價"));
                        String precautions=JOptionPane.showInputDialog("輸入你要修改注意事項");
                        String remark=JOptionPane.showInputDialog("輸入你要修改備註");
                        try {
                            EditControl editControl=new EditControl(courseName,courseDescription,applicableObject,price,precautions,remark);
                            editControl.exc();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }

                    break;
                }
                if(k==2)
                {
                    String courseID=JOptionPane.showInputDialog("輸入你要刪除課程名稱");
                    try {
                        DeleteControler deleteControler=new DeleteControler(courseID);
                        deleteControler.exc();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                }
                if(k==3)
                {
                    try
                    {
                        ShowAllCoursrView showAllCoursrView=new ShowAllCoursrView();
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
