package application.mainWindow;

import application.CourseRequestMapper;
import application.dialogWindow.CourseDialogHelper;
import delivery.*;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MainWindowController {
    @FXML
    private TableView courseTableView;
    @FXML
    private Button editCourseButton;
    @FXML
    private Button deleteCourseButton;
    @FXML
    private final ObservableList<ObservableCourse> courses = FXCollections.observableArrayList();

    private AddCourseController addCourseController;
    private DeleteCourseController deleteCourseController;
    private UpdateCourseController updateCourseController;
    private GetAllCourseController getAllCourseController;

    @FXML
    public void initialize() {
        setButtonDisableProperty(editCourseButton);
        setButtonDisableProperty(deleteCourseButton);
    }

    @Autowired
    public void setAddCourseController(AddCourseController addCourseController) {
        this.addCourseController = addCourseController;
    }

    @Autowired
    public void setDeleteCourseController(DeleteCourseController deleteCourseController) {
        this.deleteCourseController = deleteCourseController;
    }

    @Autowired
    public void setUpdateCourseController(UpdateCourseController updateCourseController) {
        this.updateCourseController = updateCourseController;
    }

    @Autowired
    public void setGetAllCourseController(GetAllCourseController getAllCourseController) {
        this.getAllCourseController = getAllCourseController;
    }

    private void setButtonDisableProperty(Button button) {
        button.disableProperty().bind(Bindings.isEmpty(courseTableView.getSelectionModel().getSelectedItems()));
    }

    @FXML
    public ObservableList<ObservableCourse> getCourses() {
        return courses;
    }

    @FXML
    public void pressShowCourseButton(ActionEvent event) {
        refreshCourseTableView();
    }

    @FXML
    public void pressAddCourseButton(ActionEvent event) throws IOException {
        final String TITLE = "Add Course";
        Optional<CourseRequestModel> newCourse = new CourseDialogHelper().display(TITLE);
        newCourse.ifPresent(course -> {
            AddCourseResponseModel responseModel = addCourseController.addCourse(course);
            showAlert(responseModel);
            refreshCourseTableView();
        });
    }

    @FXML
    public void pressEditCourseButton(ActionEvent event) throws IOException {
        final String TITLE = "Edit Course";
        Optional<ObservableCourse> selectedCourse = getTableSelectedItem();

        if (selectedCourse.isPresent()) {
            Optional<CourseRequestModel> editedCourse = new CourseDialogHelper().display(TITLE, selectedCourse.get());
            editedCourse.ifPresent(course -> {
                CourseRequestModel courseWithId = new CourseRequestModel.Builder(course).id(selectedCourse.get().getId()).build();
                UpdateCourseResponseModel responseModel = updateCourseController.updateCourse(courseWithId);
                showAlert(responseModel);
                refreshCourseTableView();
            });
        }
    }

    @FXML
    public void pressDeleteCourseButton(ActionEvent event) {
        Optional<ObservableCourse> selectedCourse = getTableSelectedItem();
        if (selectedCourse.isPresent()) {
            DeleteCourseResponseModel responseModel = deleteCourseController.deleteCourse(CourseRequestMapper.toCourseRequestModel(selectedCourse.get()));
            showAlert(responseModel);
            refreshCourseTableView();
        }
    }

    private Optional<ObservableCourse> getTableSelectedItem() {
        ObservableList selected = courseTableView.getSelectionModel().getSelectedItems();
        return selected.size() > 0 ? Optional.of((ObservableCourse) selected.get(0)) : Optional.empty();
    }

    private void refreshCourseTableView() {
        GetAllCourseResponseModel responseModel = getAllCourseController.getAllCourse();
        if (responseModel.isError()) {
            showAlert(responseModel);
        } else {
            courseTableView.getItems().clear();
            courseTableView.getItems().addAll(responseModel.getCourseList());
        }
    }

    private void showAlert(IResponseModel responseModel) {
        if (responseModel.isError())
            showErrorAlert(responseModel.getMessage());
        else
            showInformationAlert(responseModel.getMessage());
    }

    private void showInformationAlert(String message) {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setHeaderText(message);
        informationAlert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText(message);
        errorAlert.showAndWait();
    }

    private void closeWindow() {
        Stage stage = (Stage) courseTableView.getScene().getWindow();
        stage.close();
    }
}
