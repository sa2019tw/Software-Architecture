package core.entity;

import java.lang.reflect.Field;
import java.util.Objects;

public class Course {
    private Integer id;
    private String title;
    private String description;
    private String suitablePeople;
    private Integer price;
    private String announcement;
    private String remark;

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

        public Course build() {
            return new Course(this);
        }
    }

    private Course(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.suitablePeople = builder.suitablePeople;
        this.price = builder.price;
        this.announcement = builder.announcement;
        this.remark = builder.remark;
    }

    public Integer getId() {
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

    public Integer getPrice() {
        return price;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return String.format("id=%d, Title=%s, Description=%s, SuitablePeople=%s, Price=%d, Announcement=%s, Remark=%s",
                id, title, description, suitablePeople, price, announcement, remark);
    }

    @Override
    public boolean equals(Object object) {
        Field[] fields = getClass().getDeclaredFields();
        for (Field each : fields) {
            if (each.getName().equals("id"))
                continue;

            try {
                if (!Objects.equals(each.get(this), each.get(object))) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}