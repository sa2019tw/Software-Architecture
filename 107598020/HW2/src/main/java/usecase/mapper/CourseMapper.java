package usecase.mapper;

import entity.Course;
import usecase.input.CourseDTO;

import java.util.ArrayList;
import java.util.List;

public class CourseMapper {

    public CourseMapper() {
    }

    public List<Course> mapperToCourse(List<CourseDTO> courseDTOs) {
        List<Course> results = new ArrayList<Course>();

        for (CourseDTO courseDTO : courseDTOs)
            results.add(this.mapper(courseDTO));

        return results;
    }

    public Course mapperToCourse(CourseDTO courseDTO) {
        return mapper(courseDTO);
    }

    public List<CourseDTO> mapperToCourseDTO(List<Course> courses) {
        List<CourseDTO> result = new ArrayList<CourseDTO>();

        for (Course course : courses)
            result.add(this.mapper(course));

        return result;
    }

    public CourseDTO mapperToCourseDTO(Course course) {
        return mapper(course);
    }

    private CourseDTO mapper(Course course) {
        return new CourseDTO(course.getId(),
                            course.getName(),
                            course.getDescription(),
                            course.getTargetCluster(),
                            course.getPrice(),
                            course.getCourseNotice(),
                            course.getNotes());
    }

    private Course mapper(CourseDTO courseFTO) {
        return new Course(courseFTO.getId(),
                courseFTO.getName(),
                courseFTO.getDescription(),
                courseFTO.getTargetCluster(),
                courseFTO.getPrice(),
                courseFTO.getCourseNotice(),
                courseFTO.getNotes());
    }
}
