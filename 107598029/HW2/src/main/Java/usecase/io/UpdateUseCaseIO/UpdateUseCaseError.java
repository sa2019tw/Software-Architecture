package usecase.io.UpdateUseCaseIO;

public class UpdateUseCaseError implements UpdateUseCaseErrorInterface {
    private String errorMessage = "";

    public String getErrorMessage(){ return errorMessage; }

    public void reportError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public boolean hasError(){
        if(this.errorMessage.isEmpty())
            return false;
        return true;
    }
}
