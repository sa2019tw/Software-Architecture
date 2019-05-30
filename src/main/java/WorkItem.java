import java.util.UUID;

public class WorkItem {
    private String name;
    private String id;

    public WorkItem(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }


    public String getName() {
        return name;

    }

    public String getId() {
        return id;
    }
}
