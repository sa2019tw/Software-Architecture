package dto;

public class CourseDto {
    private int id;
    private String name;
    private String level;
    private int price;
    private String description;
    private String precautions;
    private String remarks;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
