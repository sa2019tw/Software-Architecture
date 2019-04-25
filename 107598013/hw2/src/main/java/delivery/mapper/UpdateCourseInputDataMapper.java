package delivery.mapper;

import core.boundary.input.UpdateCourseInputData;
import delivery.CourseRequestModel;

import static utility.StringConvertUtil.convertEmptyStringToNull;
import static utility.StringConvertUtil.convertStringToInteger;

public class UpdateCourseInputDataMapper {
    public static UpdateCourseInputData toInputData(CourseRequestModel requestModel) {
        return new UpdateCourseInputData.Builder(convertEmptyStringToNull(requestModel.getTitle()))
                .id(convertStringToInteger(requestModel.getId()))
                .description(convertEmptyStringToNull(requestModel.getDescription()))
                .suitablePeople(convertEmptyStringToNull(requestModel.getSuitablePeople()))
                .price(convertStringToInteger(requestModel.getPrice()))
                .announcement(convertEmptyStringToNull(requestModel.getAnnouncement()))
                .remark(convertEmptyStringToNull(requestModel.getRemark()))
                .build();
    }
}
