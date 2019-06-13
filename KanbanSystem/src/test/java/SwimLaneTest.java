import org.junit.Test;

import static org.junit.Assert.*;

public class SwimLaneTest {

    class Subscriber implements DomainEventSubscriber<WorkItemMovedOut>{
        public Boolean isReceivedEvent = false;
        public WorkItemMovedOut workItemMovedOut;
        @Override
        public void handleEvent(WorkItemMovedOut aDomainEvent) {
            isReceivedEvent = true;
            workItemMovedOut = aDomainEvent;
        }

        @Override
        public Class<WorkItemMovedOut> subscribedToEventType() {
            return WorkItemMovedOut.class;
        }
    }

    @Test
    public void unCommitWorkItemPublishAWorkItemMovedOutDomainEvent() {
        Subscriber subscriber = new Subscriber();
        DomainEventPublisher.instance().subscribe(subscriber);

        SwimLane swimLane = new SwimLane("1","swimLane");
        swimLane.commitWorkItem("2");
        swimLane.unCommitWorkItem("2");
        assertTrue(subscriber.isReceivedEvent);
        assertEquals(swimLane.getId(),subscriber.workItemMovedOut.getSwimLaneId());
        assertEquals("2",subscriber.workItemMovedOut.getWorkItemId());
    }
}