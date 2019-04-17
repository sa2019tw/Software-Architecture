package main.UI;
import main.ManageCourseusecase.ShowAllCourse.ShowAllCourseOutput;
import main.Repository.InText;
import main.control.ShowControler;
import main.entity.Course;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class ShowAllCoursrView {

    ShowAllCoursrView() throws IOException {
        Vector<Vector> rowData = new Vector<Vector>();
        JFrame frame = new JFrame();
        Vector<String> col = new Vector<String>();
        col.addElement("課程名稱");
        col.addElement("課程說明");
        col.addElement("適合對象");
        col.addElement("定價");
        col.addElement("注意事項");
        col.addElement("備註");
        ShowControler showControler=new ShowControler();
        showControler.exc();
        ShowAllCourseOutput showAllCourseOutput=showControler.showAllCourseOutput;
        List<Course> allCourse=showAllCourseOutput.getAllCourse();
        System.out.print(allCourse.size());
        for(int i=0;i<allCourse.size();i++)
        {
            Vector<String> row = new Vector<String>();
            row.add(allCourse.get(i).getCourseName());
            row.add(allCourse.get(i).getCourseDescription());
            row.add(allCourse.get(i).getApplicableObject());
            row.add(allCourse.get(i).getPrecautions());
            row.add(allCourse.get(i).getPrice());
            row.add(allCourse.get(i).getRemark());
            rowData.add(row);
        }
        JTable table = new JTable(rowData, col);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
