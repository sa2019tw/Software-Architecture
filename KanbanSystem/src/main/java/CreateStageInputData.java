public class CreateStageInputData {
    private int boardId;
    private String stageName;

    public CreateStageInputData(int boardId, String stageName) {
        this.boardId = boardId;
        this.stageName = stageName;
    }

    public int getBoardId() {
        return boardId;
    }

    public String getStageName() {
        return stageName;
    }
}
