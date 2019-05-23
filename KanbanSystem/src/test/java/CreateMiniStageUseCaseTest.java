import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateMiniStageUseCaseTest {

    @Test
    public void CreateMiniStage(){
        StageRepository stageRepository = new InMemoryStageRepository();
        CreateStageInputData inputData1 = new CreateStageInputData(1, "First Stage");
        CreateStageOutputData outputData1 = new CreateStageOutputData();

        CreateStageUseCase useCase = new CreateStageUseCase(stageRepository);
        useCase.execute(inputData1, outputData1);

        CreateMiniStageUseCase createMiniStageUseCase = new CreateMiniStageUseCase(stageRepository);
        String miniStageName = "First MiniStage";
        CreateMiniStageInputData createMiniStageInputData = new CreateMiniStageInputData(outputData1.getStageId(), miniStageName);
        CreateMiniStageOutputData createMiniStageOutputData =new CreateMiniStageOutputData();

        createMiniStageUseCase.execute(createMiniStageInputData ,createMiniStageOutputData);
        assertNotNull(createMiniStageOutputData.getMiniStageId());
        assertEquals(2,stageRepository.findStage(outputData1.getStageId()).getMiniStageSize());
    }
}
