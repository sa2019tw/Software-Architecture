package entity;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuitablePeople() {
        return suitablePeople;
    }

    public void setSuitablePeople(String suitablePeople) {
        this.suitablePeople = suitablePeople;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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