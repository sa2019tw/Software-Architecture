package input.findCourse;

public class findCourseInputImpl implements findCourseInput {
    private int ID;
    public findCourseInputImpl(int ID) {
        this.ID = ID;
    }
    @Override
    public int getID() {
        return ID;
    }
}
