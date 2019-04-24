package view;

import dto.CourseDto;
import model.Course;

public class detailedCourseViewModel implements ViewModel<CourseDto> {

    private int price;
    private int numberOfPeople;
    private String name;
    private String note;
    private String remark;
    private String suitable;
    private String description;

    @Override
    public ViewModel<CourseDto> setViewModel(CourseDto viewModel) {
        description =  viewModel.getDescription();
        name = viewModel.getName();
        note = viewModel.getNote();
        price = viewModel.getPrice();
        numberOfPeople = viewModel.getNumberOfPeople();
        remark = viewModel.getRemark();
        suitable = viewModel.getSuitable();
        return this;
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
