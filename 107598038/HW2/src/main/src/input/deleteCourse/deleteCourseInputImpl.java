package input.deleteCourse;

public class deleteCourseInputImpl implements deleteCourseInput {
    int ID;
    public deleteCourseInputImpl(int ID){
        this.ID = ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public int getID() {
        return ID;
    }

}
