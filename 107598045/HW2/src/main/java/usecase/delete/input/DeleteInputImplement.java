package usecase.delete.input;

public class DeleteInputImplement implements DeleteInput {
    private String[] choiceCourseId;

    public DeleteInputImplement(String[] choiceCourseId) {
        this.choiceCourseId = choiceCourseId;
    }

    @Override
    public String[] getChoiceCourseId() {
        return choiceCourseId;
    }
}
