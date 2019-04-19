package main.entity;

public class Course
{
    private String courseName;
    private String courseDescription;
    private String applicableObject;
    private int price;
    private String precautions;
    private String remark;
    public  Course()
    {

    }
    public Course(String courseName, String courseDescription, String applicableObject, int price, String precautions, String remark) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.applicableObject = applicableObject;
        this.price = price;
        this.precautions = precautions;
        this.remark = remark;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getApplicableObject() {
        return applicableObject;
    }

    public void setApplicableObject(String applicableObject) {
        this.applicableObject = applicableObject;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
