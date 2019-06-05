import org.junit.Test;

import static org.junit.Assert.*;

public class CreateStageUseCaseTest {


    @Test
    public void createTwoStage() {
        StageRepository stageRepository = new InMemoryStageRepository();
        String stageId1 = Utility.createStage(stageRepository,1,"First Stage");
        String stageId2 = Utility.createStage(stageRepository,1,"Second Stage");

        assertNotNull(stageId1);
        assertNotNull(stageId2);

        Stage stage1 = stageRepository.findStage(stageId1);
        Stage stage2 = stageRepository.findStage(stageId2);
        assertEquals("First Stage", stage1.getStageName());
        assertEquals("Second Stage", stage2.getStageName());
        assertEquals(1, stage1.getMiniStageSize());
        assertEquals(1, stage2.getMiniStageSize());
    }
}