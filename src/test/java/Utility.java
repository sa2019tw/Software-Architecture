public class Utility {


    public static String createStage(StageRepository stageRepository, int boardId, String stageName){
        CreateStageInputData inputData1 = new CreateStageInputData(boardId, stageName);
        CreateStageOutputData outputData1 = new CreateStageOutputData();

        CreateStageUseCase useCase = new CreateStageUseCase(stageRepository);
        useCase.execute(inputData1, outputData1);

        return outputData1.getStageId();
    }

    public static String createMiniStage(String stageId,StageRepository stageRepository){
        CreateMiniStageUseCase createMiniStageUseCase = new CreateMiniStageUseCase(stageRepository);
        String miniStageName = "First MiniStage";
        CreateMiniStageInputData createMiniStageInputData =
                new CreateMiniStageInputData(stageId, miniStageName);
        CreateMiniStageOutputData createMiniStageOutputData =
                new CreateMiniStageOutputData();
        createMiniStageUseCase.execute(createMiniStageInputData ,createMiniStageOutputData);

        return createMiniStageOutputData.getMiniStageId();

    }
}
