package delivery;

import core.entity.Course;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class ObservableCourse {
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty suitablePeople = new SimpleStringProperty();
    private final StringProperty price = new SimpleStringProperty();
    private final StringProperty announcement = new SimpleStringProperty();
    private final StringProperty remark = new SimpleStringProperty();

    public static class Builder {
        private Integer id;
        private String title;
        private String description;
        private String suitablePeople;
        private Integer price;
        private String announcement;
        private String remark;

        public Builder(String title) {
            Objects.requireNonNull(title);
            this.title = title;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder suitablePeople(String suitablePeople) {
            this.suitablePeople = suitablePeople;
            return this;
        }

        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public Builder announcement(String announcement) {
            this.announcement = announcement;
            return this;
        }

        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public ObservableCourse build() {
            return new ObservableCourse(this);
        }
    }

    public ObservableCourse() {

    }

    public ObservableCourse(Builder builder) {
        id.set(builder.id == null ? null : builder.id.toString());
        title.set(builder.title);
        description.set(builder.description);
        suitablePeople.set(builder.suitablePeople);
        price.set(builder.price == null ? null : builder.price.toString());
        announcement.set(builder.announcement);
        remark.set(builder.remark);
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
