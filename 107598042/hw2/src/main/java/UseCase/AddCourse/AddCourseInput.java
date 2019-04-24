package UseCase.AddCourse;


public class AddCourseInput {
    public String courseName;
    public String description;
    public String notes;
    public String remark;
    public String suitableObject;
    public double price;

    public AddCourseInput(String courseName, String description, String notes, String remark, String suitableObject, double price) {
        this.courseName = courseName;
        this.description = description;
        this.notes = notes;
        this.remark = remark;
        this.suitableObject = suitableObject;
        this.price = price;
    }
}
