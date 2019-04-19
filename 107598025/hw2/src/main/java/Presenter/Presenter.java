package Presenter;

import Output.Output;
import UseCase.OutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements OutputBoundary {

    private ViewModel viewModel;
    private Output output;
    private List<Output> outputList = new ArrayList<Output>();
    private boolean success;

    public Presenter(ViewModel viewModel){
        this.viewModel = viewModel;
    }

    public List<Output> getOutputList(){
        return outputList;
    }

    public Output getOutput(){
        return output;
    }

    public void setOutputList(List<Output> outputList){
        this.outputList = outputList;
    }

    public void setOutput(Output output){
        this.output = output;
    }

    public boolean stateSuccess(boolean success){
        return success;
    }

}
