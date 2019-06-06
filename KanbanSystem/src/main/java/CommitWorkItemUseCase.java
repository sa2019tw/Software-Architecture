public class CommitWorkItemUseCase {
    StageRepository stageRepository;
    public CommitWorkItemUseCase(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public void execute(CommitWorkItemInputData commitWorkItemInputData, CommitWorkItemOutputData commitWorkItemOutputData) {
        String stageId = commitWorkItemInputData.getStageId();
        Stage stage = stageRepository.findStage(stageId);
        SwimLane swimLane = stage.getSwimLaneById(commitWorkItemInputData.getSwimLaneId());
        swimLane.commitWorkItem(commitWorkItemInputData.getWorkItemId());
        stageRepository.update(stage);
    }
}
