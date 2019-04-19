package dao;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import model.Course;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExcelCourseDao implements CourseDao {
    String path = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("..\\database\\coursedata.xlsx")).substring(6);
    File database = new File(path);

    @Override
    public List<Course> getCourseAll() throws SQLException {
        List<Course> courseAll = new ArrayList<>();
        XSSFWorkbook xssf;

        if (database.isFile() && database.exists())
            try {
                xssf = new XSSFWorkbook(database);
                XSSFRow row = null;
                XSSFSheet sheet = xssf.getSheetAt(0);
                DataFormatter df = new DataFormatter();

                for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    row = sheet.getRow(i);
                    int j = row.getFirstCellNum();
                    Course course = new Course(
                            Integer.parseInt(df.formatCellValue(row.getCell(j++))),
                            Integer.parseInt(df.formatCellValue(row.getCell(j++))),
                            Integer.parseInt(df.formatCellValue(row.getCell(j++))),
                            df.formatCellValue(row.getCell(j++)),
                            df.formatCellValue(row.getCell(j++)),
                            df.formatCellValue(row.getCell(j++)),
                            df.formatCellValue(row.getCell(j++)),
                            df.formatCellValue(row.getCell(j++))
                    );
                    courseAll.add(course);
                }

                return courseAll;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public Course selectCourse(int ID) throws SQLException {
        XSSFWorkbook xssf;

        if (database.isFile() && database.exists())
            try {
                xssf = new XSSFWorkbook(database);
                XSSFRow row = null;
                XSSFSheet sheet = xssf.getSheetAt(0);
                DataFormatter df = new DataFormatter();

                for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    row = sheet.getRow(i);
                    int j = row.getFirstCellNum();

                    if (ID == Integer.parseInt(df.formatCellValue(row.getCell(0)))) {
                        Course course = new Course(
                                Integer.parseInt(df.formatCellValue(row.getCell(j++))),
                                Integer.parseInt(df.formatCellValue(row.getCell(j++))),
                                Integer.parseInt(df.formatCellValue(row.getCell(j++))),
                                df.formatCellValue(row.getCell(j++)),
                                df.formatCellValue(row.getCell(j++)),
                                df.formatCellValue(row.getCell(j++)),
                                df.formatCellValue(row.getCell(j++)),
                                df.formatCellValue(row.getCell(j++))
                        );

              return course;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public void insertCourse(Course course) throws SQLException {
        XSSFWorkbook xssf = null;
        XSSFRow row = null;
        FileInputStream input = null;
        XSSFSheet sheet = null;

        List<Integer> allID = new ArrayList<>();
        DataFormatter df = new DataFormatter();
        int maxID = 2147483647;

        if (database.isFile() && database.exists())
            try {
                input = new FileInputStream(database);
                xssf = new XSSFWorkbook(input);
                input.close();
                sheet = xssf.getSheetAt(0);

                if(sheet.getPhysicalNumberOfRows() > 1){
                    for(int i = sheet.getFirstRowNum() + 1;i < sheet.getPhysicalNumberOfRows();i++){
                        row = sheet.getRow(i);
                        allID.add(Integer.parseInt(df.formatCellValue(row.getCell(row.getFirstCellNum()))));
                        System.out.println(Integer.parseInt(df.formatCellValue(row.getCell(row.getFirstCellNum()))));
                    }
                    for(int i = 1;i < maxID;i++)
                       if(!allID.contains(i)){
                          course.setID(i);
                          break;
                       }
                }else if(sheet.getPhysicalNumberOfRows() == 0){
                    course.setID(1);
                }
                row = ((XSSFSheet) sheet).createRow(sheet.getPhysicalNumberOfRows());
             //   row = ((XSSFSheet) sheet).getRow(sheet.getPhysicalNumberOfRows());

                System.out.println(row);

                row.createCell(0).setCellValue(course.getID());
                row.createCell(1).setCellValue(course.getPrice());
                row.createCell(2).setCellValue(0);
                row.createCell(3).setCellValue(course.getName());
                row.createCell(4).setCellValue(course.getNote());
                row.createCell(5).setCellValue(course.getRemark());
                row.createCell(6).setCellValue(course.getSuitable());
                row.createCell(7).setCellValue(course.getDescription());

                FileOutputStream output = new FileOutputStream(database);
                xssf.write(output);
                output.close();
            }
             catch(IOException e){
                 e.printStackTrace();
             }
    }

    @Override
    public void deleteCourse(int ID) throws SQLException {
        XSSFWorkbook xssf = null;
        XSSFRow row = null;
        FileInputStream input = null;
        XSSFSheet sheet = null;

        if (database.isFile() && database.exists())
            try {
                input = new FileInputStream(database);
                xssf = new XSSFWorkbook(input);
                input.close();
                sheet = xssf.getSheetAt(0);
                DataFormatter df = new DataFormatter();

                int j = -1;
                for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    row = sheet.getRow(i);
                    j = row.getFirstCellNum();
                    System.out.println(Integer.parseInt(df.formatCellValue(row.getCell(j))));
                    if (ID == Integer.parseInt(df.formatCellValue(row.getCell(j)))) {
                        System.out.println("v:"+ID);
                        sheet.shiftRows(i+1,sheet.getPhysicalNumberOfRows(),-1);
                    }
                }

                FileOutputStream output = new FileOutputStream(database);
                xssf.write(output);
                output.close();

            }catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        XSSFWorkbook xssf = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        FileInputStream input = null;
        XSSFSheet sheet = null;

        DataFormatter df = new DataFormatter();

        if (database.isFile() && database.exists())
            try {
                input = new FileInputStream(database);
                xssf = new XSSFWorkbook(input);
                input.close();
                sheet = xssf.getSheetAt(0);

                if(sheet.getPhysicalNumberOfRows() > 1){
                    for(int i = sheet.getFirstRowNum() + 1;i < sheet.getPhysicalNumberOfRows();i++){
                        row = sheet.getRow(i);
                        cell = row.getCell(row.getFirstCellNum());

                        if(Integer.parseInt(df.formatCellValue(cell)) == course.getID()){
                            row.getCell(1).setCellValue(course.getPrice());
                            row.getCell(2).setCellValue(0);
                            row.getCell(3).setCellValue(course.getName());
                            row.getCell(4).setCellValue(course.getNote());
                            row.getCell(5).setCellValue(course.getRemark());
                            row.getCell(6).setCellValue(course.getSuitable());
                            row.getCell(7).setCellValue(course.getDescription());
                        }
                    }
                }

                FileOutputStream output = new FileOutputStream(database);
                xssf.write(output);
                output.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }
}
