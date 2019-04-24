package UseCase;

import Output.OutputData;

import java.util.List;

public interface OutputBoundary {

    void setOutputData(OutputData outputData);
    void setOutputDataList(List<OutputData> outputDataList);

}
