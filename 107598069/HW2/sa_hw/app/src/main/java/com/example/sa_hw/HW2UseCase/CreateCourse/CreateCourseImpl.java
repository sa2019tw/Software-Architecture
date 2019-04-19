package com.example.sa_hw.HW2UseCase.CreateCourse;

import com.example.sa_hw.HW2Domain.HW2Course;
import com.example.sa_hw.HW2UseCase.CourseRepository;

public class CreateCourseImpl implements CreateCourse{

    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private CourseRepository courseRepository;

    public CreateCourseImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(CreateCourseInput input, CreateCourseOutput output) {
        HW2Course hw2Course = new HW2Course(input.getCourseName(),
                                             input.getCourseIntroduction(),
                                             input.getCourseSuitable(),
                                             input.getCoursePrice(),
                                             input.getCourseNotice(),
                                             input.getCourseRemark());
        output.setCourseName(input.getCourseName());//?設CourseName
        courseRepository.create(hw2Course);
    }
}