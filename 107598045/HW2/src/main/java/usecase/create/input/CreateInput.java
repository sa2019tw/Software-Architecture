package usecase.create.input;

import usecase.Input;

public interface CreateInput extends Input {
    int getCourseId();
    String getCourseName();
    String getCourseDetail();
    String getCourseSuitPeople();
    int getCoursePrice();
    String getCourseNotes();
    String getCourseRemark();
}
