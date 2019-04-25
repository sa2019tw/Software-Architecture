package application;

import delivery.CourseRequestModel;
import delivery.ObservableCourse;

public class CourseRequestMapper {
    public static CourseRequestModel toCourseRequestModel(ObservableCourse course) {
        return new CourseRequestModel.Builder(course.getTitle())
                .id(course.getId())
                .description(course.getDescription())
                .suitablePeople(course.getSuitablePeople())
                .price(course.getPrice())
                .announcement(course.getAnnouncement())
                .remark(course.getRemark())
                .build();
    }
}
