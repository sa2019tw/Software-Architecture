package main.ManageCourseusecase.EditCourse;

public class EditCourseOutput {
    public  EditCourseOutput() {
        System.out.println("Edit course success!");
    }
    private String applicableObject;
    private String price;
    private String precautions;
    private String remark;
    private String courseDescription;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
