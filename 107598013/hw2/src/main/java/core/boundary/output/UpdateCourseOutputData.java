package core.boundary.output;

public class UpdateCourseOutputData {
    private int rowEffected;

    public UpdateCourseOutputData(int rowEffected) {
        this.rowEffected = rowEffected;
    }

    public int getRowEffected() {
        return rowEffected;
    }
}
