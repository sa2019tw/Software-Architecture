package Presenter;

import Output.OutputData;
import UseCase.OutputBoundary;

import java.util.List;

public class UpdateCoursePresenter implements OutputBoundary {
    private ViewModel viewModel;
    private boolean isSuccess;

    public UpdateCoursePresenter() {
        this.viewModel = new ViewModel();
    }

    @Override
    public void setOutputData(OutputData outputData) {
        isSuccess = outputData.getIsSuccess();
    }

    @Override
    public void setOutputDataList(List<OutputData> outputDataList) {

    }

    public void buildViewModel() {
        viewModel.setIsSuccess(isSuccess);
    }

    public ViewModel getViewModel() {
        return this.viewModel;
    }
}
