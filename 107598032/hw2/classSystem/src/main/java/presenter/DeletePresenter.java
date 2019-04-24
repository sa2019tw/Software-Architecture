package presenter;

import usecase.output.DeleteOutputInterface;
import view.ViewModel;

public class DeletePresenter implements Presenter, DeleteOutputInterface{
    private String errorMessage = "";

    @Override
    public boolean isSuccess() {
        if(this.errorMessage.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void reportError(String message) {
        this.errorMessage = message;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }

    @Override
    public ViewModel buildViewModel() {
        return null;
    }
}
