public interface WorkItemRepository {
    WorkItem findWorkItem(String workItemId);

    void addWorkItem(WorkItem workItem);
}
