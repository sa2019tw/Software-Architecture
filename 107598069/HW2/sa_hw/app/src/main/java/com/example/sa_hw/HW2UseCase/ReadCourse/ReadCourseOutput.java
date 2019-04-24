package com.example.sa_hw.HW2UseCase.ReadCourse;

import android.database.Cursor;

public interface ReadCourseOutput {
    Cursor getAllCourses();

    void setAllCourses(Cursor cursor);
}
