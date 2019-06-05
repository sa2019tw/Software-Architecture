import java.util.ArrayList;
import java.util.List;

public class InMemoryWorkItemRepository implements WorkItemRepository {

    List<WorkItem> workItems = new ArrayList<>();

    @Override
    public WorkItem findWorkItem(String workItemId) {
        for (int i = 0; i < workItems.size(); i++) {
            if (workItems.get(i).getId().equals(workItemId))
                return workItems.get(i);
        }
        throw new RuntimeException("WorkItem Not Found");
    }

    @Override
    public void addWorkItem(WorkItem workItem) {
        workItems.add(workItem);
    }
}
