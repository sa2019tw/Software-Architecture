package usecase.io.ReadAllUseCaseIO;

import usecase.io.Input;

public interface ReadAllUseCaseInputInterface extends Input {
    public int getId();

    public void setId(int id);

    public String getCourseName();

    public void setCourseName(String coursename);

    public String getCourseLevel();

    public void setCourseLevel(String courselevel);

    public int getPrice();

    public void setPrice(int price);

    public String getDescription();

    public void setDescription(String description);

    public String getPrecautions();

    public void setPrecautions(String precautions);

    public String getRemarks();

    public void setRemarks(String remarks);
}
