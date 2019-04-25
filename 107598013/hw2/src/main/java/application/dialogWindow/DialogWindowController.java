package application.dialogWindow;

import delivery.CourseRequestModel;
import delivery.ObservableCourse;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DialogWindowController {
    @FXML
    private GridPane rootGridPane;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField suitablePeopleTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField announcementTextField;
    @FXML
    private TextField remarkTextField;
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;

    private boolean isConfirm;

    public void initialize() {
        isConfirm = false;
        setNumericPriceTextField();
        setConfirmButtonDisableProperty();
    }

    private void setNumericPriceTextField() {
        priceTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                if (!newValue.matches("\\d*")) {
//                    priceTextField.setText(newValue.replaceAll("[^\\d]", ""));
//                }
                if (!newValue.matches("\\d*") || newValue.length() > 9) {
                    priceTextField.setText(oldValue);
                }
            }
        });
    }

    private void setConfirmButtonDisableProperty() {
        BooleanBinding booleanBind = titleTextField.textProperty().isEmpty();
        confirmButton.disableProperty().bind(booleanBind);
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void pressConfirmButton() {
        isConfirm = true;
        getStage().close();
    }

    public void pressCancelButton() {
        isConfirm = false;
        getStage().close();
    }

    public CourseRequestModel getCourse() {
        return new CourseRequestModel.Builder(titleTextField.getText())
                .description(descriptionTextField.getText())
                .suitablePeople(suitablePeopleTextField.getText())
                .price(priceTextField.getText())
                .announcement(announcementTextField.getText())
                .remark(remarkTextField.getText())
                .build();
    }

    public void setCourse(ObservableCourse course) {
        titleTextField.setText(checkNullString(course.getTitle()));
        descriptionTextField.setText(checkNullString(course.getDescription()));
        suitablePeopleTextField.setText(checkNullString(course.getSuitablePeople()));
        priceTextField.setText(checkNullString(course.getPrice()));
        announcementTextField.setText(checkNullString(course.getAnnouncement()));
        remarkTextField.setText(checkNullString(course.getRemark()));
    }

    private Stage getStage() {
        return (Stage) rootGridPane.getScene().getWindow();
    }

    private String checkNullString(String courseField) {
        return courseField == null ? "" : courseField;
    }
}
