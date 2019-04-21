package usecase.output.list;

import model.Course;

import java.util.List;

public class ListOutputImplement implements ListOutputInterface {
    private List<Course> courseList;
    private String errorMessage = "";
    @Override
    public void setCourses(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public List<Course> getCourses() {
        return courseList;
    }

    @Override
    public Course getCourseById(int id) {
        for(Course temp: courseList){
            if(temp.getId() == id)
                return temp;
        }
        throw new NullPointerException("Not found!");
    }

    @Override
    public void reportError(String message) {

    }

    public boolean isSuccess(){
        if(this.errorMessage.isEmpty())
            return true;
        else
            return false;
    }

    public String getMessage() {
        return errorMessage;
    }
}
