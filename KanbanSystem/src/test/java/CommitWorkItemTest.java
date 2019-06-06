import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CommitWorkItemTest {
    @Test
    public void commitWorkItemTest() {
        WorkItemRepository workItemRepository = new InMemoryWorkItemRepository();

        CreateWorkItemInputData inputData = new CreateWorkItemInputData("First Work Item");
        CreateWorkItemOutputData outputData = new CreateWorkItemOutputData();
        CreateWorkItemUseCase useCase = new CreateWorkItemUseCase(workItemRepository);

        useCase.execute(inputData, outputData);
        StageRepository stageRepository = new InMemoryStageRepository();
        String stageId = Utility.createStage(stageRepository, 0, "Backlog");

        Stage backlog = stageRepository.findStage(stageId);

        assertEquals(0, backlog.getDefaultSwimLane().getCommittedWorkItems().size());

        CommitWorkItemInputData commitWorkItemInputData =
                new CommitWorkItemInputData(stageId, backlog.getDefaultSwimLane().getId(), outputData.getWorkItemId());
        CommitWorkItemOutputData commitWorkItemOutputData = new CommitWorkItemOutputData();
        CommitWorkItemUseCase commitWorkItemUseCase = new CommitWorkItemUseCase(stageRepository);

        commitWorkItemUseCase.execute(commitWorkItemInputData, commitWorkItemOutputData);
        assertEquals(1, backlog.getDefaultSwimLane().getCommittedWorkItems().size());
    }
}
