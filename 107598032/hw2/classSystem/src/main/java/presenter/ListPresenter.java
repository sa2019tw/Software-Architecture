package presenter;

import dto.CourseDto;
import usecase.output.ListOutputInterface;
import view.ListViewModel;

import java.util.List;

public class ListPresenter implements  Presenter<ListViewModel>, ListOutputInterface {
    List<CourseDto> courseDtoList;
    private String errorMessage = "";
    @Override
    public ListViewModel buildViewModel() {
        ListViewModel viewModel = new ListViewModel();
        viewModel.setViewModel(courseDtoList);
        return viewModel;
    }

    @Override
    public void setCourses(List<CourseDto> courseList) {
        this.courseDtoList = courseList;
    }

    @Override
    public List<CourseDto> getCourses() {
        return courseDtoList;
    }

    @Override
    public CourseDto getCourseById(int id) {
        for(CourseDto temp: courseDtoList){
            if(temp.getId() == id)
                return temp;
        }
        errorMessage = "Not found!";
        return null;
    }

    @Override
    public boolean isSuccess() {
        if(this.errorMessage.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void reportError(String message) {
        this.errorMessage = message;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
