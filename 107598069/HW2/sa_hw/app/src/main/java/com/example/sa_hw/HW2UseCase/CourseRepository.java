package com.example.sa_hw.HW2UseCase;

import android.database.Cursor;

import com.example.sa_hw.CourseDTO;
import com.example.sa_hw.HW2Domain.HW2Course;

import java.util.Iterator;
import java.util.Map;

public interface CourseRepository {
    void create(HW2Course course);
    void update(String id, HW2Course course);
    void delete(String id);
    Cursor readAll();
    Cursor getCourseByID(String id);
    void destoryDB();
    Iterator<Map.Entry<Integer,CourseDTO>> readinmemory();
}
