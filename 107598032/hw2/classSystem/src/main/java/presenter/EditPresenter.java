package presenter;

import usecase.output.EditOutputInterface;
import view.ViewModel;

public class EditPresenter implements Presenter, EditOutputInterface {
    private String errorMessage = "";
    @Override
    public ViewModel buildViewModel() {
        return null;
    }

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
}
