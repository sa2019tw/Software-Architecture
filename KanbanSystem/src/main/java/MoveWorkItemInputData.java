public class MoveWorkItemInputData {


    private String originalStageId;
    private String destinationStageId;
    private String originalSwimLaneId;
    private String destinationSwimLaneId;
    private String workItemId;
    public MoveWorkItemInputData(String originalStageId,
                                 String originalSwimLaneId,
                                 String destinationStageId,
                                 String destinationSwimLaneId,
                                 String workItemId) {
        this.originalStageId = originalStageId;
        this.originalSwimLaneId = originalSwimLaneId;
        this.destinationStageId = destinationStageId;
        this.destinationSwimLaneId = destinationSwimLaneId;
        this.workItemId = workItemId;
    }

    public String getOriginalStageId() {
        return originalStageId;
    }

    public String getDestinationStageId() {
        return destinationStageId;
    }

    public String getOriginalSwimLaneId() {
        return originalSwimLaneId;
    }

    public String getDestinationSwimLaneId() {
        return destinationSwimLaneId;
    }

    public String getWorkItemId() {
        return workItemId;
    }
}
