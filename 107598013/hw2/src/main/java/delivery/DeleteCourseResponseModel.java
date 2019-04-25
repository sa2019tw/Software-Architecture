package delivery;

public class DeleteCourseResponseModel extends AbstractResponseModel {
    private DeleteCourseResponseModel(boolean isError, String message) {
        super(isError, message);
    }

    public static DeleteCourseResponseModel getErrorModel(String message) {
        return new DeleteCourseResponseModel(true, message);
    }

    public static DeleteCourseResponseModel getResultModel(String message) {
        return new DeleteCourseResponseModel(false, message);
    }
}
