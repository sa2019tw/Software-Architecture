package io;

import dto.CourseDto;

import java.util.ArrayList;

public class UseCaseOutput {
    private ArrayList<CourseDto> courseDtos = new ArrayList<>();
    private CourseDto courseDto = null;

    public void setCourseInfoDto(CourseDto courseDto){ this.courseDto = courseDto; }

    public CourseDto getCourseInfo(){ return courseDto; }

    public ArrayList<CourseDto> getCourses(){
        return courseDtos;
    }

    public void addCoursesDto(CourseDto courseDto){
        courseDtos.add(courseDto);
    }
}
