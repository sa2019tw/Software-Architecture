import java.util.Date;

public class WorkItemMovedOut implements DomainEvent{
    private String swimLaneId;
    private String workItemId;
    private Date date;

    public WorkItemMovedOut(String swimLaneId, String workItemId, Date date) {
        this.swimLaneId = swimLaneId;
        this.workItemId = workItemId;
        this.date = date;
    }

    @Override
    public int eventVersion() {
        return 0;
    }

    @Override
    public Date occurredOn() {
        return new Date();
    }

    public String getSwimLaneId() {
        return swimLaneId;
    }

    public String getWorkItemId() {
        return workItemId;
    }
}
