import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Stage {
    private String name;
    private String stageId;
    private int boardId;
    private List<MiniStage> miniStages = new ArrayList<>();

    public Stage(int boardId, String name) {
        this.name = name;
        this.stageId = UUID.randomUUID().toString();
        this.boardId = boardId;
        addMiniStage(new MiniStage(stageId,"default mini stage"));
    }

    public String getStageName() {
        return name;
    }

    public int getMiniStageSize() {
        return miniStages.size();
    }

    public String getStageId() {
        return stageId;
    }

    public void addMiniStage(MiniStage miniStage) {
        miniStages.add(miniStage);
    }

    public MiniStage getMiniStage(String miniStageId) {
        for(int i=0;i<miniStages.size();i++){
            if(miniStages.get(i).getMinStageId().equals(miniStageId))
                return miniStages.get(i);
        }
        throw new RuntimeException("MiniStage not found");
    }

    public SwimLane getDefaultSwimLane() {
        return miniStages.get(0).getDefaultSwimLane();
    }

    public SwimLane getSwimLaneById(String swimLaneId) {
        for(MiniStage miniStage: miniStages){
            if(miniStage.isSwimLaneExist(swimLaneId))
                return miniStage.getSwimLaneById(swimLaneId);
        }
        throw new RuntimeException("SwimLane not found, Id = "+swimLaneId);
    }
}
