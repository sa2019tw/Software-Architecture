package dao;
import com.google.common.base.MoreObjects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CourseDao {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty description;
    private final SimpleStringProperty targetCluster;
    private final SimpleIntegerProperty price;
    private final SimpleStringProperty courseNotice;
    private final SimpleStringProperty notes;


    public CourseDao(int id) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
        this.targetCluster = new SimpleStringProperty("");
        this.price = new SimpleIntegerProperty(0);
        this.courseNotice = new SimpleStringProperty("");
        this.notes = new SimpleStringProperty("");
    }

    public CourseDao(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty("");
        this.targetCluster = new SimpleStringProperty("");
        this.price = new SimpleIntegerProperty(0);
        this.courseNotice = new SimpleStringProperty("");
        this.notes = new SimpleStringProperty("");
    }

    public void setId() {};

    public int getId() {
        return id.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getTargetCluster() {
        return targetCluster.get();
    }

    public void setTargetCluster(String targetCluster) {
        this.targetCluster.set(targetCluster);
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public String getCourseNotice() {
        return courseNotice.get();
    }

    public void setCourseNotice(String courseNotice) {
        this.courseNotice.set(courseNotice);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public void copyValue(CourseDao that) {
        this.price.set(that.getPrice());
        this.courseNotice.set(that.getCourseNotice());
        this.description.set(that.getDescription());
        this.name.set(that.getName());
        this.notes.set(that.getNotes());
        this.targetCluster.set(that.getTargetCluster());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("name", name)
                .add("description", description)
                .add("targetCluster", targetCluster)
                .add("price", price)
                .add("courseNotice", courseNotice)
                .add("notes", notes).toString();
    }

    @Override
    public boolean equals(Object others) {
        CourseDao that = (CourseDao) others;
        return this.id.get() == that.id.get() &&
                this.price.get() == that.price.get() &&
                this.courseNotice.get().equalsIgnoreCase(that.courseNotice.get()) &&
                this.description.get().equalsIgnoreCase(that.description.get()) &&
                this.name.get().equalsIgnoreCase(that.name.get()) &&
                this.notes.get().equalsIgnoreCase(that.notes.get()) &&
                this.targetCluster.get().equalsIgnoreCase(that.targetCluster.get());
    }

}
