package model;

public class Course {
    private int ID;
    private int price;
    private int numberOfPeople;
    private String name;
    private String note;
    private String remark;
    private String suitable;
    private String description;

    public Course(){}

    public Course(int price, int numberOfPeople, String name, String note, String remark, String suitable, String description) {
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.name = name;
        this.note = note;
        this.remark = remark;
        this.suitable = suitable;
        this.description = description;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public void setDescription(String description){this.description = description;}


    public int getID() {
        return ID;
    }

    public int getPrice() {
        return this.price;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getName() {
        return name;
    }

    public String getNote() { return this.note; }

    public String getRemark() {
        return this.remark;
    }

    public String getSuitable() {
        return this.suitable;
    }

    public String getDescription(){return this.description;}

}
