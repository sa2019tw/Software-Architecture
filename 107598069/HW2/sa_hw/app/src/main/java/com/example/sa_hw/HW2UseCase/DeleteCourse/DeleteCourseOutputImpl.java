package com.example.sa_hw.HW2UseCase.DeleteCourse;

public class DeleteCourseOutputImpl implements DeleteCourseOutput {
    private String courseID;

    @Override
    public void setMessage(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public String getMessage() {
        return courseID;
    }
}
