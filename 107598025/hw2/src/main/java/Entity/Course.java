package Entity;

public class Course {
    private String courseName;
    private String courseDescription;
    private String courseTarget;
    private int coursePrice;
    private String courseAttention;
    private String courseRemark;

    public Course(){}

    public Course(String courseName, String courseDescription, String courseTarget, int coursePrice, String courseAttention, String courseRemark){
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseTarget = courseTarget;
        this.coursePrice = coursePrice;
        this.courseAttention = courseAttention;
        this.courseRemark = courseRemark;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String course_name){
        this.courseName = course_name;
    }

    public String getCourseDescription(){
        return courseDescription;
    }

    public void setCourseDescription(String course_description){
        this.courseDescription = course_description;
    }

    public String getCourseTarget(){
        return courseTarget;
    }

    public void setCourseTarget(String course_target){
        this.courseTarget = course_target;
    }

    public int getCoursePrice(){
        return coursePrice;
    }

    public void setCoursePrice(int course_price){
        this.coursePrice = course_price;
    }

    public String getCourseAttention(){
        return courseAttention;
    }

    public void setCourseAttention(String course_attention){
        this.courseAttention = course_attention;
    }

    public String getCourseRemark(){
        return courseRemark;
    }

    public void setCourseRemark(String course_remark){
        this.courseRemark = course_remark;
    }

}
