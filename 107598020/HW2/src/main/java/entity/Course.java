package entity;

public class Course {
    private int id;
    private String name;
    private String description;
    private String targetCluster;
    private int price;
    private String courseNotice;
    private String notes;

    public Course(int id) {
        this.id = id;
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(int id, String name, String description, String targetCluster, int price, String courseNotice, String notes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetCluster = targetCluster;
        this.price = price;
        this.courseNotice = courseNotice;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetCluster() {
        return targetCluster;
    }

    public void setTargetCluster(String targetCluster) {
        this.targetCluster = targetCluster;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCourseNotice() {
        return courseNotice;
    }

    public void setCourseNotice(String courseNotice) {
        this.courseNotice = courseNotice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
