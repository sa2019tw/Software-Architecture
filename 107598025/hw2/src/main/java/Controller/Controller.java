package Controller;

import Input.Input;
import UseCase.OutputBoundary;

public class Controller {

    private InputBoundary useCaseDistributor;
    private OutputBoundary presenter;
    private Input input;

    public Controller(InputBoundary useCaseInteractor, OutputBoundary presenter){
        this.useCaseDistributor = useCaseInteractor;
        this.presenter = presenter;
    }

    public void addCourse(String courseName, String courseDescription, String courseTarget, int coursePrice, String courseAttention, String courseRemark){
        input = new Input(courseName, courseDescription, courseTarget, coursePrice, courseAttention, courseRemark);
        useCaseDistributor.executeAddCourseUseCase(input, presenter);
    }

    public void retrieveOneCourse(String courseName, String courseDescription, String courseTarget, int coursePrice, String courseAttention, String courseRemark){
        input = new Input(courseName, courseDescription, courseTarget, coursePrice, courseAttention, courseRemark);
        useCaseDistributor.executeRetrieveOneCourseUseCase(input, presenter);
    }

    public void retrieveAllCourse(){
        useCaseDistributor.executeRetrieveAllCourseUseCase(input, presenter);
    }

    public void updateCourse(String courseName, String courseDescription, String courseTarget, int coursePrice, String courseAttention, String courseRemark){
        input = new Input(courseName, courseDescription, courseTarget, coursePrice, courseAttention, courseRemark);
        useCaseDistributor.executeUpdateCourseUseCase(input, presenter);
    }

    public void deleteCourse(String courseName, String courseDescription, String courseTarget, int coursePrice, String courseAttention, String courseRemark){
        input = new Input(courseName, courseDescription, courseTarget, coursePrice, courseAttention, courseRemark);
        useCaseDistributor.executeDeleteCourseUseCase(input, presenter);
    }

    public OutputBoundary getPresenter(){
    return presenter;
    }

}
