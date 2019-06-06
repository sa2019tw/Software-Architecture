import java.util.ArrayList;
import java.util.List;

public class InMemoryStageRepository implements StageRepository {
    private List<Stage> stageList = new ArrayList<>();

    @Override
    public Stage findStage(String stageId) {
        for(int i = 0; i < stageList.size(); i++){
            if(stageList.get(i).getStageId().equals(stageId))
                return stageList.get(i);
        }
        throw new RuntimeException("stage not found");
    }

    @Override
    public void addStage(Stage stage) {
        stageList.add(stage);
    }

    @Override
    public void update(Stage stage) {

    }
}
