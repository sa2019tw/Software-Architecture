package Presenter;

import Output.OutputData;
import UseCase.OutputBoundary;

import java.util.List;


public class AddCoursePresenter implements OutputBoundary {

    private ViewModel viewModel;
    private boolean isSuccess;

    public AddCoursePresenter(){
        this.viewModel = new ViewModel();
    }

    @Override
    public void setOutputData(OutputData outputData) {
        isSuccess = outputData.getIsSuccess();
    }

    public void buildViewModel() {
        viewModel.setIsSuccess(isSuccess);
    }

    public ViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public void setOutputDataList(List<OutputData> outputDataList) {

    }
}
