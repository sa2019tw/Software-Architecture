package usecase.create.input;

public class CreateInputImplement implements CreateInput{
    private int courseId;
    private String courseName;
    private String courseDetail;
    private String courseSuitPeople;
    private int coursePrice;
    private String courseNotes;
    private String courseRemark;

    public CreateInputImplement(String course_name, String course_detail, String course_suit_people,
                                int course_price, String course_notes, String course_remark)
    {
        if (course_name.isEmpty()) {
            throw new IllegalArgumentException("課程名稱不能為空");
        }
        this.courseName = course_name;
        this.courseDetail = course_detail;
        this.courseSuitPeople = course_suit_people;
        this.coursePrice = course_price;
        this.courseNotes = course_notes;
        this.courseRemark = course_remark;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDetail() {
        return courseDetail;
    }

    public String getCourseSuitPeople() {
        return courseSuitPeople;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public String getCourseNotes() {
        return courseNotes;
    }

    public String getCourseRemark() {
        return courseRemark;
    }
}
