package core.boundary.output;

public class DeleteCourseOutputData {
    private int rowEffected;

    public DeleteCourseOutputData(int rowEffected) {
        this.rowEffected = rowEffected;
    }

    public int getRowEffected() {
        return rowEffected;
    }
}
