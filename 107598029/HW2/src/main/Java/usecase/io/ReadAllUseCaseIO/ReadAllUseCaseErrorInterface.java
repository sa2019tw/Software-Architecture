package usecase.io.ReadAllUseCaseIO;

import usecase.io.Error;

public interface ReadAllUseCaseErrorInterface extends Error {
    public String getErrorMessage();

    public void reportError(String errorMessage);

    public boolean hasError();
}
