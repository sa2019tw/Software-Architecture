import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateMiniStageUseCaseTest {

    @Test
    public void CreateMiniStage(){
        StageRepository stageRepository = new InMemoryStageRepository();

        String stageId = Utility.createStage(stageRepository, 1, "first stage");
        assertNotNull(stageId);
        Stage stage = stageRepository.findStage(stageId);
        assertEquals(1,stage.getMiniStageSize());

        String miniStageId = Utility.createMiniStage(stageId, stageRepository);
        assertNotNull(miniStageId);
        assertEquals(2,stage.getMiniStageSize());

        MiniStage miniStage = stage.getMiniStage(miniStageId);
        assertEquals(1,miniStage.getSwimLaneSize());
    }
}
