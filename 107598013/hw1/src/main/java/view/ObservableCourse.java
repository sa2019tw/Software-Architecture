package view;

import entity.Course;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObservableCourse {
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();;
    private final StringProperty suitablePeople = new SimpleStringProperty();;
    private final StringProperty price = new SimpleStringProperty();
    private final StringProperty announcement = new SimpleStringProperty();;
    private final StringProperty remark = new SimpleStringProperty();;

    public ObservableCourse() {

    }

    public ObservableCourse(Course course) {
        id.set(course.getId() == null ? null : course.getId().toString());
        title.set(course.getTitle());
        description.set(course.getDescription());
        suitablePeople.set(course.getSuitablePeople());
        price.set(course.getPrice() == null ? null : course.getPrice().toString());
        announcement.set(course.getAnnouncement());
        remark.set(course.getRemark());
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getSuitablePeople() {
        return suitablePeople.get();
    }

    public StringProperty suitablePeopleProperty() {
        return suitablePeople;
    }

    public void setSuitablePeople(String suitablePeople) {
        this.suitablePeople.set(suitablePeople);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getAnnouncement() {
        return announcement.get();
    }

    public StringProperty announcementProperty() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement.set(announcement);
    }

    public String getRemark() {
        return remark.get();
    }

    public StringProperty remarkProperty() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark.set(remark);
    }
}
