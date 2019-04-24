package com.example.sa_hw.HW2UseCase.UpdateCourse;

public class UpdateCourseOutputImpl implements UpdateCourseOutput{
    private String newCourseName;

    @Override
    public String getNewCourseName() {
        return newCourseName;
    }

    @Override
    public void setNewCourseName(String newCourseName) {
        this.newCourseName = newCourseName;
    }
}
