package usecase.output;

public interface OutputInterface {
    boolean isSuccess();
    void reportError(String message);
    String getMessage();
}
