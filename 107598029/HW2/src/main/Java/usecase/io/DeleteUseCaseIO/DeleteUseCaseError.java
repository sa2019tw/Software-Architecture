package usecase.io.DeleteUseCaseIO;

public class DeleteUseCaseError implements DeleteUseCaseErrorInterface {
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
