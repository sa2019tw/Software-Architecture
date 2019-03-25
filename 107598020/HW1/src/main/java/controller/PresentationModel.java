package controller;

import dao.CourseDao;
import dao.CourseManager;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class PresentationModel {
    private CourseManager courseManager;
    private CourseDao targetCourse;
    /**
     * function mode :
     *      -1 : none
     *       0 : modify mode
     *       1 : add mode
     *       2 : delete mode
     */
    private int functionMode;

    public PresentationModel() {
        targetCourse = null;
        courseManager = new CourseManager();
        functionMode = -1;
    }


    public void setTargetCourse(CourseDao selectedItem) {
        targetCourse = selectedItem;
    }

    public boolean isNoTarget() {
        return targetCourse == null;
    }

    public int getMode() {
        return functionMode;
    }

    public void setMode(int mode) {
        functionMode = mode;
    }

    public List<CourseDao> getCourseList() {
        return courseManager.getCourseList();
    }

    public CourseDao getTargetCourse() {
        return targetCourse;
    }

    public void updateCourse(CourseDao course) {
        courseManager.updateCourse(course);
    }

    public void addCourse(CourseDao course) {
        courseManager.addCourse(course);
    }

    public void deleteCourse() {
        courseManager.deleteCourse(targetCourse);
    }

    public boolean isEmptyString(String text) {
        text.replaceAll("\\n", "");
        return text.equalsIgnoreCase("");
    }

    public boolean isNumberLegal(String text) {
        if (text.length() > 0)
            return isPositiveNumeric(text);
        return true;
    }

    private boolean isPositiveNumeric(String str) {
        try {
            double num = Double.parseDouble(str);
            System.out.println("parse num : " + num);
            return (num >= 0) ? true : false;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public int transferToInteger(String text) {
        if (text.length() > 0)
            return Integer.valueOf(text);
        return 0;
    }
}
