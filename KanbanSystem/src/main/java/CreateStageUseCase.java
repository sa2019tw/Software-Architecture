public class CreateStageUseCase {
    private StageRepository stageRepository;
    public CreateStageUseCase(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public void execute(CreateStageInputData inputData, CreateStageOutputData outputData) {
        Stage stage = new Stage(inputData.getBoardId(), inputData.getStageName());
        stageRepository.addStage(stage);
        outputData.setStageId(stage.getStageId());

    }
}
