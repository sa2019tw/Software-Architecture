package com.example.sa_hw.HW2UseCase.ReadCourse;

import android.database.Cursor;

public class ReadCourseOutputImpl implements ReadCourseOutput {

    Cursor cursor;

    @Override
    public Cursor getAllCourses() {
        return cursor;
    }

    @Override
    public void setAllCourses(Cursor cursor) {
        this.cursor = cursor;
    }
}
