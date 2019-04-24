package usecase.output;

import usecase.output.OutputInterface;

public interface InsertOutputInterface extends OutputInterface {
    void reportError(String errorMessage);
    boolean isSuccess();
    String getMessage();
}
