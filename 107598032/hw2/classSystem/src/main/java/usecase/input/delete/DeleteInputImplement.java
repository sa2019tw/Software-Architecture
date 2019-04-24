package usecase.input.delete;

import java.util.List;

public class DeleteInputImplement implements DeleteInputInterface {
    private List<Integer> id;

    public DeleteInputImplement(List<Integer> id){
        this.id = id;
    }

    @Override
    public List<Integer> getIdList() {
        return id;
    }
}
