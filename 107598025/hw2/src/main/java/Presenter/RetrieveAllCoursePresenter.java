package Presenter;

import Output.OutputData;
import UseCase.OutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class RetrieveAllCoursePresenter implements OutputBoundary {

    private ViewModel viewModel;
    private List<OutputData> outputDataList;
    private List<ViewModel> viewModelList = new ArrayList<>();

    public RetrieveAllCoursePresenter(){
        this.viewModel = new ViewModel();
    }

    public void setOutputData(OutputData outputData) { }

    @Override
    public void setOutputDataList(List<OutputData> outputDataList) {
        this.outputDataList = outputDataList;
    }

    private void convertOutputDataListToViewModelList(){
        for (OutputData outputData: this.outputDataList) {
            ViewModel viewModel = new ViewModel(outputData.getCourseName(),
                    outputData.getCourseDescription(),
                    outputData.getCourseTarget(),
                    String.valueOf(outputData.getCoursePrice()),
                    outputData.getCourseAttention(),
                    outputData.getCourseRemark());
            viewModelList.add(viewModel);
        }
    }

    public void buildViewModel() {
        convertOutputDataListToViewModelList();
        this.viewModel.setViewModelList(viewModelList);
    }

    public ViewModel getViewModel() {
        return this.viewModel;
    }
}
