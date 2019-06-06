import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MiniStage {
    private String stageId;
    private String minStageId;
    private String name;
    private List<SwimLane> swimLanes = new ArrayList<>();

    public MiniStage(String stageId, String miniStageName) {
        this.minStageId = UUID.randomUUID().toString();
        this.stageId = stageId;
        this.name = miniStageName;
        addSwimLane(new SwimLane(minStageId, "Default SwimLane"));
    }

    public void addSwimLane(SwimLane swimLane) {
        swimLanes.add(swimLane);
    }

    public String getMiniStageName() {
        return name;
    }

    public String getMinStageId() {
        return minStageId;
    }

    public int getSwimLaneSize() {
        return swimLanes.size();
    }

    public SwimLane getSwimLane(String swimLaneId) {
        for (int i = 0; i < swimLanes.size(); i++) {
            if (swimLanes.get(i).getId().equals(swimLaneId))
                return swimLanes.get(i);
        }
        throw new RuntimeException("SwimLane Not Found");
    }

    public SwimLane getDefaultSwimLane() {
        return swimLanes.get(0);
    }

    public boolean isSwimLaneExist(String swimLaneId) {
        return swimLanes.stream().
                filter(each -> each.getId().equals(swimLaneId)).findFirst().isPresent();
    }

    public SwimLane getSwimLaneById(String swimLaneId) {
        if (!this.isSwimLaneExist(swimLaneId))
            throw new RuntimeException("SwimLane not found");
        return swimLanes.stream().
                filter(each -> each.getId().equals(swimLaneId)).findFirst().get();
    }
}
