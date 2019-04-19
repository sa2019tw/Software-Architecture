package View;

import Controller.Controller;
import Output.Output;
import UseCase.OutputBoundary;
import Presenter.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    public TableView<Output> courseListTable = new TableView<>();;

    @FXML
    public TableColumn<Output, String> courseNameColumn = new TableColumn<>();

    @FXML
    public TableColumn<Output, String> courseDescriptionColumn = new TableColumn<>();

    @FXML
    public TableColumn<Output, String> courseTargetColumn = new TableColumn<>();

    @FXML
    public TableColumn<Output, String> coursePriceColumn = new TableColumn<>();

    @FXML
    public TableColumn<Output, String> courseAttentionColumn = new TableColumn<>();

    @FXML
    public TableColumn<Output, String> courseRemarkColumn = new TableColumn<>();

    private Controller controller;
    private OutputBoundary presenter;
    private ViewModel viewModel;

    public void initialize(Controller controller) {
        this.controller = controller;
        refresh();
    }

    public void addButtonClicked () {
        checkPriceEmpty();
        controller.addCourse(courseName.getText(), courseDescription.getText(), courseTarget.getText(), Integer.parseInt(coursePrice.getText()), courseAttention.getText(), courseRemark.getText());
        refresh();
        clearInputBox();
    }

    public void retrieveButtonClicked () {
        if(!courseName.getText().isEmpty()){
            checkPriceEmpty();
            controller.retrieveOneCourse(courseName.getText(), courseDescription.getText(), courseTarget.getText(), Integer.parseInt(coursePrice.getText()), courseAttention.getText(), courseRemark.getText());
            presenter = controller.getPresenter();
            Output output = presenter.getOutput();

            courseName.setText(output.getCourseName());
            courseDescription.setText(output.getCourseDescription());
            courseTarget.setText(output.getCourseTarget());
            coursePrice.setText(String.valueOf(output.getCoursePrice()));
            courseAttention.setText(output.getCourseAttention());
            courseRemark.setText(output.getCourseRemark());
        }
    }

    public void updateButtonClicked () {
        if(!courseName.getText().isEmpty()) {
            checkPriceEmpty();
            controller.updateCourse(courseName.getText(), courseDescription.getText(), courseTarget.getText(), Integer.parseInt(coursePrice.getText()), courseAttention.getText(), courseRemark.getText());

            refresh();
            clearInputBox();
        }
    }

    public void deleteButtonClicked () {
        if(!courseName.getText().isEmpty()) {
            checkPriceEmpty();
            controller.deleteCourse(courseName.getText(), courseDescription.getText(), courseTarget.getText(), Integer.parseInt(coursePrice.getText()), courseAttention.getText(), courseRemark.getText());
            refresh();
            clearInputBox();
        }
    }

    private void refresh () {

        courseListTable.setItems(getCourseList());

        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));
        courseTargetColumn.setCellValueFactory(new PropertyValueFactory<>("courseTarget"));
        coursePriceColumn.setCellValueFactory(new PropertyValueFactory<>("coursePrice"));
        courseAttentionColumn.setCellValueFactory(new PropertyValueFactory<>("courseAttention"));
        courseRemarkColumn.setCellValueFactory(new PropertyValueFactory<>("courseRemark"));
    }

    private ObservableList<Output> getCourseList() {
        ObservableList<Output> courseList = FXCollections.observableArrayList();

        controller.retrieveAllCourse();
        presenter = controller.getPresenter();
        courseList.addAll(presenter.getOutputList());

        return courseList;
    }

    private void checkPriceEmpty(){
        if(coursePrice.getText().isEmpty())
            coursePrice.setText("0");
    }

    private void clearInputBox(){
        courseName.setText("");
        courseDescription.setText("");
        courseTarget.setText("");
        coursePrice.setText("");
        courseAttention.setText("");
        courseRemark.setText("");
    }
}
