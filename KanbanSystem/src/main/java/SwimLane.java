import java.util.UUID;

public class SwimLane {
    private String miniStageId,name, id;
    private int wip = 0;

    public SwimLane(String miniStageId,String name){
        this.miniStageId = miniStageId;
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public int getWIP() {
        return this.wip;
    }
}
