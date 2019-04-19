package controller;

import usecase.input.CourseDTO;

import java.util.ArrayList;
import java.util.List;

public class CourseViewObjectMapper {

    public List<CourseViewObject> mappingToCourseViewObject(List<CourseDTO> allCourses) {
        List<CourseViewObject> result = new ArrayList<CourseViewObject>();
        for (CourseDTO course : allCourses)
            result.add(mapper(course));
        return result;
    }

    public CourseDTO mappingToCourseDTO(CourseViewObject courseViewObject) {
        return mapper(courseViewObject);
    }

    private CourseViewObject mapper(CourseDTO course) {
        return new CourseViewObject(course.getId(),
                                    course.getName(),
                                    course.getDescription(),
                                    course.getTargetCluster(),
                                    course.getPrice(),
                                    course.getCourseNotice(),
                                    course.getNotes());
    }

    private CourseDTO mapper(CourseViewObject courseViewObject) {
        return new CourseDTO(courseViewObject.getId(),
                courseViewObject.getName(),
                courseViewObject.getDescription(),
                courseViewObject.getTargetCluster(),
                courseViewObject.getPrice(),
                courseViewObject.getCourseNotice(),
                courseViewObject.getNotes());
    }
}
