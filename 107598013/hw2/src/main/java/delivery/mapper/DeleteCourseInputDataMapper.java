package delivery.mapper;

import core.boundary.input.DeleteCourseInputData;
import delivery.CourseRequestModel;

import static utility.StringConvertUtil.convertStringToInteger;

public class DeleteCourseInputDataMapper {
    public static DeleteCourseInputData toInputData(CourseRequestModel requestModel) {
        return new DeleteCourseInputData(convertStringToInteger(requestModel.getId()));
    }
}
