package usecase.io.UpdateUseCaseIO;

import usecase.io.Error;

public interface UpdateUseCaseErrorInterface extends Error {
    public String getErrorMessage();

    public void reportError(String errorMessage);

    public boolean hasError();
}
