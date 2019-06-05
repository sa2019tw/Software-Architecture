public class CreateSwimLaneUseCase {
    private StageRepository stageRepository;

    public CreateSwimLaneUseCase(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public void execute(CreateSwimLaneInputData inputData, CreateSwimLaneOutputData outputData) {
        Stage stage = stageRepository.findStage(inputData.getStageId());
        MiniStage miniStage = stage.getMiniStage(inputData.getMiniStageId());
        SwimLane swimlane = new SwimLane(miniStage.getMinStageId(), inputData.getSwimLaneName());
        miniStage.addSwimLane(swimlane);
        outputData.setSwimLaneId(swimlane.getId());
    }
}
