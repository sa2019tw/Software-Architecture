package core.useCase.mapper;

import core.boundary.input.AddCourseInputData;
import core.boundary.input.UpdateCourseInputData;
import core.entity.Course;

public class CourseMapper {
    public static Course toCourse(AddCourseInputData inputData) {
        return new Course.Builder(inputData.getTitle())
                .description(inputData.getDescription())
                .suitablePeople(inputData.getSuitablePeople())
                .price(inputData.getPrice())
                .announcement(inputData.getAnnouncement())
                .remark(inputData.getRemark())
                .build();
    }

    public static Course toCourse(UpdateCourseInputData inputData) {
        return new Course.Builder(inputData.getTitle())
                .id(inputData.getId())
                .description(inputData.getDescription())
                .suitablePeople(inputData.getSuitablePeople())
                .price(inputData.getPrice())
                .announcement(inputData.getAnnouncement())
                .remark(inputData.getRemark())
                .build();
    }
}
