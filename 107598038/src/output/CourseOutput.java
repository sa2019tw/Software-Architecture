package output;

import dto.CourseDto;

import java.util.ArrayList;
import java.util.List;

public class CourseOutput {
    private List<CourseDto> list = new ArrayList<>();
    private CourseDto course ;
    public CourseOutput(){}

    public void setlist(List<CourseDto> courseAll) {
        list = courseAll;
    }

    public List<CourseDto> getList() {
        return list;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }
    public CourseDto getCourse() {
        return course;
    }

}
