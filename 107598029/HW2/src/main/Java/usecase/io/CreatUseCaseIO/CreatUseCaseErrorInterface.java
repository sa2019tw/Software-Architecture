package usecase.io.CreatUseCaseIO;

import usecase.io.Error;

public interface CreatUseCaseErrorInterface extends Error {
    public String getErrorMessage();

    public void reportError(String errorMessage);

    public boolean hasError();
}
