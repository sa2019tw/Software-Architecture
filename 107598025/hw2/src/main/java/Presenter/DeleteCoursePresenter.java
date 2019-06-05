package Presenter;

import Output.OutputData;
import UseCase.OutputBoundary;

import java.util.List;

public class DeleteCoursePresenter implements OutputBoundary {
    private ViewModel viewModel;
    private boolean isSuccess;

    public DeleteCoursePresenter() {
        this.viewModel = new ViewModel();
    }

    @Override
    public void setOutputData(OutputData outputData) {
        this.isSuccess = outputData.getIsSuccess();
    }

    @Override
    public void setOutputDataList(List<OutputData> outputDataList) {

    }

    public boolean getOutput() {
        return false;
    }

    public void buildViewModel() {
        this.viewModel.setIsSuccess(this.isSuccess);
    }

    public ViewModel getViewModel() {
        return this.viewModel;
    }
}
