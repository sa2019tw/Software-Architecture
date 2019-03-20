package input;

public class CourseInput {

    public CourseInput(){}
    public CourseInput(int price, int numberOfPeople, String name, String note, String remark, String suitable, String description) {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
