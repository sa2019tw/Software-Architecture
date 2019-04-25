package application.exceptionWindow;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ExceptionWindowController {
    @FXML
    private TextArea messageTextArea;

    public void setMessage(String message) {
        messageTextArea.setText(message);
    }
}
