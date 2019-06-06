public class CommitWorkItemInputData {
    String stageId;
    String swimLaneId;
    String workItemId;
    public CommitWorkItemInputData(String stageId, String swimLaneId, String workItemId) {
        this.stageId = stageId;
        this.swimLaneId = swimLaneId;
        this.workItemId = workItemId;
    }

    public String getStageId() {
        return stageId;
    }

    public String getSwimLaneId() {
        return swimLaneId;
    }

    public String getWorkItemId() {
        return workItemId;
    }
}
