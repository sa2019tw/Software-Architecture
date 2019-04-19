package com.example.sa_hw.HW2UseCase.DeleteCourse;

import com.example.sa_hw.HW2UseCase.CourseRepository;

public class DeleteCourseImpl implements DeleteCourse {

    private CourseRepository courseRepository;

    public DeleteCourseImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(DeleteCourseInput input, DeleteCourseOutput output) {
        output.setMessage(input.getCourseID());
        courseRepository.delete(input.getCourseID());
    }
}
