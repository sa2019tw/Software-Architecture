package usecase.output.insert;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class InsertOutputImplement implements InsertOutputInterface {
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
