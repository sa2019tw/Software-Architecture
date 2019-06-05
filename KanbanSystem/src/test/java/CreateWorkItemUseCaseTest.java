import org.junit.Test;

import static org.junit.Assert.*;

public class CreateWorkItemUseCaseTest {

    @Test
    public void createWorkItem() {

        WorkItemRepository workItemRepository = new InMemoryWorkItemRepository();

        CreateWorkItemInputData inputData = new CreateWorkItemInputData("First Work Item");
        CreateWorkItemOutputData outputData = new CreateWorkItemOutputData();
        CreateWorkItemUseCase useCase = new CreateWorkItemUseCase(workItemRepository);

        useCase.execute(inputData, outputData);


        WorkItem workItem = workItemRepository.findWorkItem(outputData.getWorkItemId());
        assertEquals("First Work Item", workItem.getName());
    }

}