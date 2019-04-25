package core.useCase.mapper;

import core.entity.Course;
import core.useCase.CourseDto;

public class CourseDtoMapper {
    public static CourseDto toCourseDto(Course course) {
        return new CourseDto.Builder(course.getTitle())
                .id(course.getId())
                .description(course.getDescription())
                .suitablePeople(course.getSuitablePeople())
                .price(course.getPrice())
                .announcement(course.getAnnouncement())
                .remark(course.getRemark())
                .build();
    }
}
