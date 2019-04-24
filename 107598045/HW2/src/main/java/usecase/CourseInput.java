package usecase;

public class CourseInput {
    private int courseId;
    private String courseName;
    private String courseDetail;
    private String courseSuitPeople;
    private int coursePrice;
    private String courseNotes;
    private String courseRemark;
    private String[] choiceCourseId;

    public CourseInput() {}

    public CourseInput(String course_name, String course_detail, String course_suit_people,
                       int course_price, String course_notes, String course_remark) {
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

    public CourseInput(String[] choiceCourseId) {
        this.choiceCourseId = choiceCourseId;
    }



    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDetail() {
        return courseDetail;
    }
    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }

    public String getCourseSuitPeople() {
        return courseSuitPeople;
    }
    public void setCourseSuitPeople(String courseSuitPeople) {
        this.courseSuitPeople = courseSuitPeople;
    }

    public int getCoursePrice() {
        return coursePrice;
    }
    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseNotes() {
        return courseNotes;
    }
    public void setCourseNotes(String courseNotes) {
        this.courseNotes = courseNotes;
    }

    public String getCourseRemark() {
        return courseRemark;
    }
    public void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }

    public String[] getChoiceCourseId() {
        return choiceCourseId;
    }
}
