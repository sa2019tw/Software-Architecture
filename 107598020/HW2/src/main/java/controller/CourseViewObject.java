package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CourseViewObject {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty description;
    private final SimpleStringProperty targetCluster;
    private final SimpleIntegerProperty price;
    private final SimpleStringProperty courseNotice;
    private final SimpleStringProperty notes;

    public CourseViewObject(int id, String name, String description, String targetCluster, int price, String courseNotice, String notes) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.targetCluster = new SimpleStringProperty(targetCluster);
        this.price = new SimpleIntegerProperty(price);
        this.courseNotice = new SimpleStringProperty(courseNotice);
        this.notes = new SimpleStringProperty(notes);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getTargetCluster() {
        return targetCluster.get();
    }

    public int getPrice() {
        return price.get();
    }

    public String getCourseNotice() {
        return courseNotice.get();
    }

    public String getNotes() {
        return notes.get();
    }
}
