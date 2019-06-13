import java.util.*;

public class SwimLane {
    private String miniStageId,name, id;
    private int wip = 0;
    private List<String> workItemIds;

    public SwimLane(String miniStageId,String name){
        this.miniStageId = miniStageId;
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.workItemIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getWIP() {
        return this.wip;
    }

    public List<String> getCommittedWorkItems() {
        return workItemIds;
    }

    public void commitWorkItem(String workItemId) {
        workItemIds.add(workItemId);
    }

    public void unCommitWorkItem(String workItemId) {
        workItemIds.remove(workItemId);
        DomainEventPublisher.instance().publish(new WorkItemMovedOut(id, workItemId, new Date()));
    }
}
