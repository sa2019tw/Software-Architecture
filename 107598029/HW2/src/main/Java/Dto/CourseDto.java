package Dto;

public class CourseDto {
    private int id;
    private String name;
    private String level;
    private int price;
    private String description;
    private String precautions;
    private String remarks;
    public CourseDto(){}
    public CourseDto(int id, String name, String level, int price, String description, String precautions, String remarks) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.price = price;
        this.description = description;
        this.precautions = precautions;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return name;
    }

    public String getCourseLevel() {
        return level;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getPrecautions() {
        return precautions;
    }

    public String getRemarks() {
        return remarks;
    }
}
