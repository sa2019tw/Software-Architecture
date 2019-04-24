package view;

import dto.CourseDto;

public class findCourseViewModel implements ViewModel<CourseDto> {
    private int ID;
    private int price;
    private int numberOfPeople;
    private String name;
    private String note;
    private String remark;
    private String suitable;
    private String description;

    @Override
    public ViewModel<CourseDto> setViewModel(CourseDto viewModel) {
        ID = viewModel.getID();
        description =  viewModel.getDescription();
        name = viewModel.getName();
        note = viewModel.getNote();
        price = viewModel.getPrice();
        numberOfPeople = viewModel.getNumberOfPeople();
        remark = viewModel.getRemark();
        suitable = viewModel.getSuitable();
        return this;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return this.price;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getName() {
        return name;
    }

    public String getNote() { return this.note; }

    public String getRemark() {
        return this.remark;
    }

    public String getSuitable() {
        return this.suitable;
    }

    public String getDescription(){return this.description;}
}
