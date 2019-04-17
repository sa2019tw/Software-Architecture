package dto;

public class CourseDto {
    public CourseDto() {}
    public CourseDto(int ID, int price, int numberOfPeople, String name, String note, String remark, String suitable, String description) {
        this.ID = ID;
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.name = name;
        this.note = note;
        this.remark = remark;
        this.suitable = suitable;
        this.description = description;
    }

    private int ID;
    private int price;
    private int numberOfPeople;
    private String name;
    private String note;
    private String remark;
    private String suitable;
    private String description;

    public int getID() { return ID; }
    public int getPrice() {
        return price;
    }
    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    public String getName() {
        return name;
    }
    public String getNote() {
        return note;
    }
    public String getRemark() {
        return remark;
    }
    public String getSuitable() {
        return suitable;
    }
    public String getDescription() {
        return description;
    }
}
