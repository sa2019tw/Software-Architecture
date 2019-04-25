package delivery;

public class UpdateCourseResponseModel extends AbstractResponseModel {
    private UpdateCourseResponseModel(boolean isError, String message) {
        super(isError, message);
    }

    public static UpdateCourseResponseModel getErrorModel(String message) {
        return new UpdateCourseResponseModel(true, message);
    }

    public static UpdateCourseResponseModel getResultModel(String message) {
        return new UpdateCourseResponseModel(false, message);
    }
}
