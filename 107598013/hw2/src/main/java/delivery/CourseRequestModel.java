package delivery;

import java.util.Objects;

public class CourseRequestModel {
    private String id;
    private String title;
    private String description;
    private String suitablePeople;
    private String price;
    private String announcement;
    private String remark;

    public static class Builder {
        private String id;
        private String title;
        private String description;
        private String suitablePeople;
        private String price;
        private String announcement;
        private String remark;

        public Builder(String title) {
            Objects.requireNonNull(title);
            this.title = title;
        }

        public Builder(CourseRequestModel responseModel) {
            Objects.requireNonNull(responseModel.getTitle());
            this.id = responseModel.id;
            this.title = responseModel.getTitle();
            this.description = responseModel.description;
            this.suitablePeople = responseModel.suitablePeople;
            this.price = responseModel.price;
            this.announcement = responseModel.announcement;
            this.remark = responseModel.remark;
        }

        public Builder id(String id) {
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

        public Builder price(String price) {
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

        public CourseRequestModel build() {
            return new CourseRequestModel(this);
        }
    }

    private CourseRequestModel(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.suitablePeople = builder.suitablePeople;
        this.price = builder.price;
        this.announcement = builder.announcement;
        this.remark = builder.remark;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSuitablePeople() {
        return suitablePeople;
    }

    public String getPrice() {
        return price;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public String getRemark() {
        return remark;
    }
}
