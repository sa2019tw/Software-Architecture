public class MoveWorkItemUseCase {
    private StageRepository stageRepository;
    public MoveWorkItemUseCase(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public void execute(MoveWorkItemInputData moveWorkItemInputData, MoveWorkItemOutputData moveWorkItemOutputData) {
        Stage originalStage = stageRepository.findStage(moveWorkItemInputData.getOriginalStageId());
        Stage destinationStage = stageRepository.findStage(moveWorkItemInputData.getDestinationStageId());
        SwimLane originalSwimLane = originalStage.getSwimLaneById(moveWorkItemInputData.getOriginalSwimLaneId());
        SwimLane destinationSwimLane = destinationStage.getSwimLaneById(moveWorkItemInputData.getDestinationSwimLaneId());
        originalSwimLane.unCommitWorkItem(moveWorkItemInputData.getWorkItemId());
        destinationSwimLane.commitWorkItem(moveWorkItemInputData.getWorkItemId());


    }
}
