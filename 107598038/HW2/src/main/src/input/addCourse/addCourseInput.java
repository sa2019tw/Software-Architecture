package input.addCourse;

import input.Input;

public interface addCourseInput extends Input {

    public void setPrice(int price);
    public void setNumberOfPeople(int numberOfPeople);
    public void setName(String name);
    public void setNote(String note);
    public void setRemark(String remark);
    public void setSuitable(String suitable);
    public void setDescription(String description);


    public int getPrice();
    public int getNumberOfPeople();
    public String getName();
    public String getNote();
    public String getRemark();
    public String getSuitable();
    public String getDescription();
}
