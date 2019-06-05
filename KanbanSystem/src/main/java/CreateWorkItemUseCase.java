public class CreateWorkItemUseCase {
    private WorkItemRepository workItemRepository;
    public CreateWorkItemUseCase(WorkItemRepository workItemRepository) {
        this.workItemRepository = workItemRepository;
    }

    public void execute(CreateWorkItemInputData inputData, CreateWorkItemOutputData outputData) {
        WorkItem workItem = new WorkItem(inputData.getName());
        workItemRepository.addWorkItem(workItem);
        outputData.setWorkItemId(workItem.getId());
    }
}
