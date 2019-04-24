package com.example.sa_hw.HW2UseCase.CreateCourse;

public class CreateCourseInputImpl implements CreateCourseInput{
    private String courseName;
    private String courseIntroduction;
    private String courseSuitable;
    private int coursePrice;
    private String courseNotice;
    private String courseRemark;

    public CreateCourseInputImpl(String name, String introduction, String suitable, int price, String notice, String remark){
        setCourseName(name);
        setCourseIntroduction(introduction);
        setCourseSuitable(suitable);
        setCoursePrice(price);
        setCourseNotice(notice);
        setCourseRemark(remark);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIntroduction() {
        return courseIntroduction;
    }

    public void setCourseIntroduction(String courseIntroduction) {
        this.courseIntroduction = courseIntroduction;
    }

    public String getCourseSuitable() {
        return courseSuitable;
    }

    public void setCourseSuitable(String courseSuitable) {
        this.courseSuitable = courseSuitable;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseNotice() {
        return courseNotice;
    }

    public void setCourseNotice(String courseNotice) {
        this.courseNotice = courseNotice;
    }

    public String getCourseRemark() {
        return courseRemark;
    }

    public void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }
}
