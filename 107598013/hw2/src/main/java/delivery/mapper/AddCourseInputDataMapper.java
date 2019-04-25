package delivery.mapper;

import core.boundary.input.AddCourseInputData;
import delivery.CourseRequestModel;

import static utility.StringConvertUtil.convertEmptyStringToNull;
import static utility.StringConvertUtil.convertStringToInteger;

public class AddCourseInputDataMapper {
    public static AddCourseInputData toInputData(CourseRequestModel requestModel) {
        return new AddCourseInputData.Builder(convertEmptyStringToNull(requestModel.getTitle()))
                .description(convertEmptyStringToNull(requestModel.getDescription()))
                .suitablePeople(convertEmptyStringToNull(requestModel.getSuitablePeople()))
                .price(convertStringToInteger(requestModel.getPrice()))
                .announcement(convertEmptyStringToNull(requestModel.getAnnouncement()))
                .remark(convertEmptyStringToNull(requestModel.getRemark()))
                .build();
    }
}
