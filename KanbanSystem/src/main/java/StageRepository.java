public interface StageRepository {

    Stage findStage(String stageId);

    void addStage(Stage stage);

    void update(Stage stage);
}
