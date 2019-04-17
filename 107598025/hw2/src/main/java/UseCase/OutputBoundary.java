package UseCase;

import Output.Output;

import java.util.List;

public interface OutputBoundary {
    Output getOutput();

    List<Output> getOutputList();

    void setOutputList(List<Output> outputList);

    void setOutput(Output output);

    boolean stateSuccess(boolean success);
}
