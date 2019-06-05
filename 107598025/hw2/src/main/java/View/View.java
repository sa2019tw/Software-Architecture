package View;

import Controller.Controller;
import Controller.InputModel;
import Presenter.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class View {

    @FXML
    public TextField courseName = new TextField();

    @FXML
    public TextField courseDescription = new TextField();

    @FXML
    public TextField courseTarget = new TextField();

    @FXML
    public TextField coursePrice = new TextField();

    @FXML
    public TextField courseAttention = new TextField();

    @FXML
    public TextField courseRemark = new TextField();

    @FXML
    public Button addButton = new Button();

    @FXML
    public Button retrieveButton = new Button();

    @FXML
    public Button updateButton = new Button();

    @FXML
    public Button deleteButton = new Button();

    @FXML
    public TableView<ViewModel> courseListTable = new TableView<>();
    ;

    @FXML
    public TableColumn<ViewModel, String> courseNameColumn = new TableColumn<>();

    @FXML
    public TableColumn<ViewModel, String> courseDescriptionColumn = new TableColumn<>();

    @FXML
    public TableColumn<ViewModel, String> courseTargetColumn = new TableColumn<>();

    @FXML
    public TableColumn<ViewModel, String> coursePriceColumn = new TableColumn<>();

    @FXML
    public TableColumn<ViewModel, String> courseAttentionColumn = new TableColumn<>();

    @FXML
    public TableColumn<ViewModel, String> courseRemarkColumn = new TableColumn<>();

    private Controller controller;
    private ViewModel viewModel;

    public void initialize(Controller controller) {
        this.controller = controller;
        refresh();
    }

    public void addButtonClicked() {
        if (!courseName.getText().isEmpty()) {
            checkPriceEmpty();
            InputModel inputModel = collectData();

            viewModel = controller.addCourse(inputModel);

            alertDialogBox(viewModel.getIsSuccess());

            refresh();
            clearInputBox();
        }
    }

    private void alertDialogBox(boolean isSuccess) {
        Alert alert;
        if (isSuccess) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Success!");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed!");
        }
        alert.showAndWait();
    }

    public void retrieveButtonClicked() {
        if (!courseName.getText().isEmpty()) {
            checkPriceEmpty();
            InputModel inputModel = collectData();
            viewModel = controller.retrieveOneCourse(inputModel);

            courseName.setText(viewModel.getCourseName());
            courseDescription.setText(viewModel.getCourseDescription());
            courseTarget.setText(viewModel.getCourseTarget());
            coursePrice.setText(viewModel.getCoursePrice());
            courseAttention.setText(viewModel.getCourseAttention());
            courseRemark.setText(viewModel.getCourseRemark());
        }
    }

    public void updateButtonClicked() {
        if (!courseName.getText().isEmpty()) {
            checkPriceEmpty();
            InputModel inputModel = collectData();
            viewModel = controller.updateCourse(inputModel);

            alertDialogBox(viewModel.getIsSuccess());

            refresh();
            clearInputBox();
        }
    }

    public void deleteButtonClicked() {
        if (!courseName.getText().isEmpty()) {
            checkPriceEmpty();
            InputModel inputModel = collectData();
            viewModel = controller.deleteCourse(inputModel);
            alertDialogBox(viewModel.getIsSuccess());
            refresh();
            clearInputBox();
        }
    }

    private InputModel collectData() {
        return new InputModel(courseName.getText(),
                courseDescription.getText(),
                courseTarget.getText(),
                coursePrice.getText(),
                courseAttention.getText(),
                courseRemark.getText());
    }

    private void refresh() {
        courseListTable.setItems(getCourseList());

        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));
        courseTargetColumn.setCellValueFactory(new PropertyValueFactory<>("courseTarget"));
        coursePriceColumn.setCellValueFactory(new PropertyValueFactory<>("coursePrice"));
        courseAttentionColumn.setCellValueFactory(new PropertyValueFactory<>("courseAttention"));
        courseRemarkColumn.setCellValueFactory(new PropertyValueFactory<>("courseRemark"));
    }

    private ObservableList<ViewModel> getCourseList() {
        ObservableList<ViewModel> courseList = FXCollections.observableArrayList();
        viewModel = controller.retrieveAllCourse();
        courseList.addAll(viewModel.getViewModelList());

        return courseList;
    }

    private void checkPriceEmpty() {
        if (coursePrice.getText().isEmpty())
            coursePrice.setText("0");
    }

    private void clearInputBox() {
        courseName.setText("");
        courseDescription.setText("");
        courseTarget.setText("");
        coursePrice.setText("");
        courseAttention.setText("");
        courseRemark.setText("");
    }
}
