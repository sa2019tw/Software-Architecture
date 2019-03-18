package Domain;

// entity
public class Course {
    private String courseName = "";
    private String description = "";
    private String notes = "";
    private String remark = "";
    private String suitableObject = "";
    private double price = 0;
    private int id;

    public static Course createCourse(String courseName) {
        return new Course(courseName);
    }

    public Course(String courseName) {
        this.setCourseName(courseName);
        this.description = "";
        this.notes = "";
        this.remark = "";
        this.suitableObject = "";
        this.price = 0;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSuitableObject() {
        return suitableObject;
    }

    public void setSuitableObject(String suitableObject) {
        this.suitableObject = suitableObject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) return false;
        Course course = (Course) obj;


        return  this.courseName.equals(course.courseName) &&
                this.description.equals(course.description) &&
                this.notes.equals(course.notes) &&
                this.remark.equals(course.remark) &&
                this.suitableObject.equals(course.suitableObject) &&
                this.price == (course.price);
    }


    @Override
    public String toString() {
        String courseInfo = "Course Name: " + this.courseName;
        courseInfo += "Description" + this.description;
        courseInfo += "Price" + this.price;
        courseInfo += "Notes" + this.notes;
        courseInfo += "Remark" + this.remark;
        courseInfo += "SuitableObject" + this.suitableObject;
        courseInfo += "Id" + this.id;
        return courseInfo;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
