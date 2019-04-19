package usecase.input.delete;

public class DeleteInputImplement implements DeleteInputInterface {
    private int id;

    public DeleteInputImplement(int id){
        this.id = id;
    }

    public int getId() { return id; }
}
