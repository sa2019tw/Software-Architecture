import org.junit.Test;

import static org.junit.Assert.*;

public class CreateStageUseCaseTest {


    @Test
    public void createTwoStage() {
        StageRepository stageRepository = new InMemoryStageRepository();
        CreateStageInputData inputData1 = new CreateStageInputData(1, "First Stage");
        CreateStageOutputData outputData1 = new CreateStageOutputData();
        CreateStageInputData inputData2 = new CreateStageInputData(1, "Second Stage");
        CreateStageOutputData outputData2 = new CreateStageOutputData();
        CreateStageUseCase useCase = new CreateStageUseCase(stageRepository);
        useCase.execute(inputData1, outputData1);
        useCase.execute(inputData2, outputData2);
        assertNotNull(outputData1.getStageId());
        assertNotNull(outputData2.getStageId());

        Stage stage1 = stageRepository.findStage(outputData1.getStageId());
        Stage stage2 = stageRepository.findStage(outputData2.getStageId());
        assertEquals(inputData1.getStageName(), stage1.getStageName());
        assertEquals(inputData2.getStageName(), stage2.getStageName());
        assertEquals(1, stage1.getMiniStageSize());
        assertEquals(1, stage2.getMiniStageSize());

    }



}