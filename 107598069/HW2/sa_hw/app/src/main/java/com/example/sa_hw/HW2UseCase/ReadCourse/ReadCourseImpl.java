package com.example.sa_hw.HW2UseCase.ReadCourse;

import android.widget.ListView;

import com.example.sa_hw.HW2UseCase.CourseRepository;
import com.example.sa_hw.MainActivity;
import com.example.sa_hw.MyCursorAdapter;
import com.example.sa_hw.R;

public class ReadCourseImpl implements ReadCourse {

    private CourseRepository courseRepository;

    public ReadCourseImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(ReadCourseInput input, ReadCourseOutput output) {
        output.setAllCourses(courseRepository.readAll());
        MyCursorAdapter myCursorAdapter = new MyCursorAdapter(input.getContext(), courseRepository.readAll());
        input.getListView().setAdapter(myCursorAdapter);
    }
}
