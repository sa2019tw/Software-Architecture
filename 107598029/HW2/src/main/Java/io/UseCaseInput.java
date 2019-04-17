package io;

public class UseCaseInput {
    private int id;
    private String coursename;
    private String courselevel;
    private int price;
    private String description;
    private String precautions;
    private String remarks;

    public UseCaseInput(int id, String coursename, String courselevel, int price, String description, String precautions, String remarks){
        this.id = id;
        this.coursename = coursename;
        this.courselevel = courselevel;
        this.price = price;
        this.description = description;
        this.precautions = precautions;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCourselevel() {
        return courselevel;
    }

    public void setCourselevel(String courselevel) {
        this.courselevel = courselevel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
