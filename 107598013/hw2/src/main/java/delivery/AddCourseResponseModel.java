package delivery;

public class AddCourseResponseModel extends AbstractResponseModel {
    private AddCourseResponseModel(boolean isError, String message) {
        super(isError, message);
    }

    public static AddCourseResponseModel getErrorModel(String message) {
        return new AddCourseResponseModel(true, message);
    }

    public static AddCourseResponseModel getResultModel(String message) {
        return new AddCourseResponseModel(false, message);
    }
}
