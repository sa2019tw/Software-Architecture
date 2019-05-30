public class CreateSwimLaneInputData {
    private String stageId;
    private String miniStageId;
    private String swimLaneName;

    public CreateSwimLaneInputData(String stageId, String miniStageId, String swimLaneName) {
        this.stageId = stageId;
        this.miniStageId = miniStageId;
        this.swimLaneName = swimLaneName;
    }

    public String getStageId() {
        return stageId;
    }

    public String getMiniStageId() {
        return miniStageId;
    }

    public String getSwimLaneName() {
        return swimLaneName;
    }
}
