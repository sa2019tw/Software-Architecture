package usecase.io.DeleteUseCaseIO;

import usecase.io.Error;

public interface DeleteUseCaseErrorInterface extends Error {
    public String getErrorMessage();

    public void reportError(String errorMessage);

    public boolean hasError();
}
