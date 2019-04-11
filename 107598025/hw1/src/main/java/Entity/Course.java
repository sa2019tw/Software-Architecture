package Entity;

public class Course {
    private String course_name;
    private String course_description;
    private String course_target;
    private int course_price;
    private String course_attention;
    private String course_remark;

    public Course(){}

    public Course(String course_name, String course_description, String course_target, int course_price, String course_attention, String course_remark){
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_target = course_target;
        this.course_price = course_price;
        this.course_attention = course_attention;
        this.course_remark = course_remark;
    }

    public String getCourseName(){
        return course_name;
    }

    public void setCourseName(String course_name){
        this.course_name = course_name;
    }

    public String getCourseDescription(){
        return course_description;
    }

    public void setCourseDescription(String course_description){
        this.course_description = course_description;
    }

    public String getCourseTarget(){
        return course_target;
    }

    public void setCourseTarget(String course_target){
        this.course_target = course_target;
    }

    public int getCoursePrice(){
        return course_price;
    }

    public void setCoursePrice(int course_price){
        this.course_price = course_price;
    }

    public String getCourseAttention(){
        return course_attention;
    }

    public void setCourseAttention(String course_attention){
        this.course_attention = course_attention;
    }

    public String getCourseRemark(){
        return course_remark;
    }

    public void setCourseRemark(String course_remark){
        this.course_remark = course_remark;
    }

}
