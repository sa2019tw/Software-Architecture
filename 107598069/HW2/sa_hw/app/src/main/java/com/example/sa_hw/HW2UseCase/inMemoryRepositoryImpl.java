package com.example.sa_hw.HW2UseCase;

import android.database.Cursor;

import com.example.sa_hw.CourseDTO;
import com.example.sa_hw.HW2Domain.HW2Course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class inMemoryRepositoryImpl implements CourseRepository{

    Map<Integer, CourseDTO> inMemoryMap;

    public inMemoryRepositoryImpl(){
        inMemoryMap = new TreeMap<>();
    }

    @Override
    public void create(HW2Course course) {
        CourseDTO dto = new CourseDTO(course.getCourseName(),
                course.getCourseIntroduction(),
                course.getCourseSuitable(),
                course.getCoursePrice(),
                course.getCourseNotice(),
                course.getCourseRemark());

        inMemoryMap.put(inMemoryMap.size() + 1,dto);
    }

    @Override
    public void update(String id, HW2Course course) {
        CourseDTO dto = new CourseDTO(course.getCourseName(),
                course.getCourseIntroduction(),
                course.getCourseSuitable(),
                course.getCoursePrice(),
                course.getCourseNotice(),
                course.getCourseRemark());

        inMemoryMap.put(Integer.valueOf(id),dto);
    }

    @Override
    public void delete(String id) {
        inMemoryMap.remove(Integer.valueOf(id));
    }

    @Override
    public Cursor readAll() {
        return null;
    }

    @Override
    public Cursor getCourseByID(String id) {
        return null;
    }

    @Override
    public void destoryDB() {
        inMemoryMap.clear();
    }

    @Override
    public Iterator<Map.Entry<Integer,CourseDTO>> readinmemory() {

        return inMemoryMap.entrySet().iterator();
    }
}
