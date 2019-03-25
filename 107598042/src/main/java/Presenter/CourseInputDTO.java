package Presenter;

public class CourseInputDTO {

    public String courseName;
    public String description;
    public String notes;
    public String remark;
    public String suitableObject;
    public int price;
    public int id;

    public CourseInputDTO(String courseName, String description, String notes, String remark, String suitableObject, int price) {
        this.courseName = courseName;
        this.description = description;
        this.notes = notes;
        this.remark = remark;
        this.suitableObject = suitableObject;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
