package delivery;

public abstract class AbstractResponseModel implements IResponseModel {
    private boolean isError;
    private String message;

    public AbstractResponseModel(boolean isError, String message) {
        this.isError = isError;
        this.message = message;
    }

    @Override
    public boolean isError() {
        return isError;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
