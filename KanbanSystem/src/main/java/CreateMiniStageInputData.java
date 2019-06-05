public class CreateMiniStageInputData {
    private String stageId;
    private String name;
    CreateMiniStageInputData(String stageId, String name){
        this.stageId = stageId;
        this.name = name;
    }

    public String getStageId() {
        return stageId;
    }


    public String getMiniStageName() {
        return name;
    }
}
