public class CreateMiniStageUseCase {
    StageRepository stageRepository;
    public CreateMiniStageUseCase(StageRepository inMemoryStageRepository) {
        this.stageRepository = inMemoryStageRepository;
    }

    public void execute(CreateMiniStageInputData createMiniStageInputData, CreateMiniStageOutputData createMiniStageOutputData) {
        MiniStage miniStage = new MiniStage(createMiniStageInputData.getStageId(), createMiniStageInputData.getMiniStageName());
        Stage stage = stageRepository.findStage(createMiniStageInputData.getStageId());
        stage.addMiniStage(miniStage);
        stageRepository.addStage(stage);
        createMiniStageOutputData.setMiniStageId(miniStage.getMinStageId());
    }
}
