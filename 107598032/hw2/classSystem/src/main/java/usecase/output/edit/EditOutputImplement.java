package usecase.output.edit;


public class EditOutputImplement implements EditOutputInterface {
    private String errorMessage = "";
    public void reportError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess(){
        if(this.errorMessage.isEmpty())
            return true;
        else
            return false;
    }

    public String getMessage() {
        return errorMessage;
    }
}
