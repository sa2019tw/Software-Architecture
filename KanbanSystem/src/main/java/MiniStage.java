import java.util.UUID;

public class MiniStage {
    private String stageId;
    private String minStageId;
    private String name;

    public MiniStage(String stageId, String miniStageName) {
        this.minStageId = UUID.randomUUID().toString();
        this.stageId = stageId;
        this.name = miniStageName;
    }

    public String getMiniStageName() {
        return name;
    }
    public String getMinStageId(){
        return minStageId;
    }
}
