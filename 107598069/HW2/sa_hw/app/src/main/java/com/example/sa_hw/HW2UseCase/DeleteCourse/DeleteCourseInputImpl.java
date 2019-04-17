package com.example.sa_hw.HW2UseCase.DeleteCourse;

public class DeleteCourseInputImpl implements DeleteCourseInput {
    private String courseID;

    public DeleteCourseInputImpl(String id){
        setCourseID(id);
    }

    @Override
    public String getCourseID() {
        return courseID;
    }

    @Override
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
