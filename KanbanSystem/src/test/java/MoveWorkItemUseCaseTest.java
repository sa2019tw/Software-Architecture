import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoveWorkItemUseCaseTest {
    private String stageId;
    private StageRepository stageRepository;
    private WorkItemRepository workItemRepository;
    private String workItemId;
    private Stage backlog;
    private Stage analysis;


    @Before
    public void setUp() {
        workItemRepository = new InMemoryWorkItemRepository();

        CreateWorkItemInputData inputData = new CreateWorkItemInputData("First Work Item");
        CreateWorkItemOutputData outputData = new CreateWorkItemOutputData();
        CreateWorkItemUseCase useCase = new CreateWorkItemUseCase(workItemRepository);
        useCase.execute(inputData, outputData);
        workItemId = outputData.getWorkItemId();
        stageRepository = new InMemoryStageRepository();
        stageId = Utility.createStage(stageRepository, 0, "Backlog");
        String analysisId= Utility.createStage(stageRepository, 0, "Analysis");
        backlog = stageRepository.findStage(stageId);
        analysis = stageRepository.findStage(analysisId);
        assertEquals(0, backlog.getDefaultSwimLane().getCommittedWorkItems().size());

        CommitWorkItemInputData commitWorkItemInputData =
                new CommitWorkItemInputData(stageId, backlog.getDefaultSwimLane().getId()
                        , outputData.getWorkItemId());
        CommitWorkItemOutputData commitWorkItemOutputData = new CommitWorkItemOutputData();
        CommitWorkItemUseCase commitWorkItemUseCase = new CommitWorkItemUseCase(stageRepository);

        commitWorkItemUseCase.execute(commitWorkItemInputData, commitWorkItemOutputData);
        assertEquals(1, backlog.getDefaultSwimLane().getCommittedWorkItems().size());

    }

    @Test
    public void moveWorkItemFromBackLogToAnalysis() {
        MoveWorkItemUseCase moveWorkItemUseCase = new MoveWorkItemUseCase(stageRepository);
        MoveWorkItemInputData moveWorkItemInputData = new MoveWorkItemInputData(backlog.getStageId()
                ,backlog.getDefaultSwimLane().getId(),
                analysis.getStageId(),
                analysis.getDefaultSwimLane().getId(),workItemId);
        MoveWorkItemOutputData moveWorkItemOutputData = new MoveWorkItemOutputData();
        moveWorkItemUseCase.execute(moveWorkItemInputData, moveWorkItemOutputData);
        assertEquals(0, backlog.getDefaultSwimLane().getCommittedWorkItems().size());
        assertEquals(1, analysis.getDefaultSwimLane().getCommittedWorkItems().size());
    }
}