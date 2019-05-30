import org.junit.Test;

import static org.junit.Assert.*;

public class CreateSwimLaneUseCaseTest {

    @Test
    public void createSwimLane(){
        StageRepository stageRepository = new InMemoryStageRepository();
        String stageId = Utility.createStage(stageRepository, 1, "First Stage");
        String miniStageId = Utility.createMiniStage(stageId, stageRepository);
        MiniStage miniStage = stageRepository.findStage(stageId).getMiniStage(miniStageId);

        assertEquals(1, miniStage.getSwimLaneSize());

        CreateSwimLaneInputData inputData = new CreateSwimLaneInputData(stageId, miniStageId, "First SwimLane");
        CreateSwimLaneOutputData outputData = new CreateSwimLaneOutputData();
        CreateSwimLaneUseCase useCase = new CreateSwimLaneUseCase(stageRepository);
        useCase.execute(inputData, outputData);

        assertNotNull(outputData.getSwimLaneId());

        assertEquals(2, miniStage.getSwimLaneSize());

        SwimLane swimLane = miniStage.getSwimLane(outputData.getSwimLaneId());
        assertEquals(0, swimLane.getWIP());
    }

}