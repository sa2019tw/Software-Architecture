import java.util.Date;

public interface DomainEvent {

    public int eventVersion();

    public Date occurredOn();
}