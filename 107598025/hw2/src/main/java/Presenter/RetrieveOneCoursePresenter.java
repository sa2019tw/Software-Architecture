package Presenter;

import Output.OutputData;;
import UseCase.OutputBoundary;

import java.util.List;

public class RetrieveOneCoursePresenter implements OutputBoundary {
    private ViewModel viewModel;
    private OutputData outputData;

    public RetrieveOneCoursePresenter() {
        this.viewModel = new ViewModel();
    }

    @Override
    public void setOutputData(OutputData outputData) {
        this.outputData = outputData;
    }

    @Override
    public void setOutputDataList(List<OutputData> outputDataList) {

    }

    public void buildViewModel() {
        this.viewModel = new ViewModel(outputData.getCourseName(),
                outputData.getCourseDescription(),
                outputData.getCourseTarget(),
                String.valueOf(outputData.getCoursePrice()),
                outputData.getCourseAttention(),
                outputData.getCourseRemark());
    }

    public ViewModel getViewModel() {
        return this.viewModel;
    }
}
