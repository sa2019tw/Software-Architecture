package input.detailedCourse;

import input.detailedCourse.detailedCourseInput;

public class detailedCourseInputImpl implements detailedCourseInput {
    private int ID;
    public detailedCourseInputImpl(int ID) {
        this.ID = ID;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID;}

}