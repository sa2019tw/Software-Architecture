package delivery.mapper;

import core.useCase.CourseDto;
import delivery.ObservableCourse;

public class ObservableCourseMapper {
    public static ObservableCourse toObservableCourse(CourseDto course) {
        return new ObservableCourse.Builder(course.getTitle())
                .id(course.getId())
                .description(course.getDescription())
                .suitablePeople(course.getSuitablePeople())
                .price(course.getPrice())
                .announcement(course.getAnnouncement())
                .remark(course.getRemark())
                .build();
    }
}
