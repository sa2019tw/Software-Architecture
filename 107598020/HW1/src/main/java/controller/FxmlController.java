package controller;

import dao.CourseDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FxmlController implements Initializable {
    private PresentationModel pm;

//    private CourseManager courseManager;

    private final String GRAY = "#DCDCDC";
    private final String WHITE = "#FFF";
    private final String RED = "#FF0000";

    private final ObservableList<CourseDao> data = FXCollections.observableArrayList();
    private final int MODIFY_MODE = 0;
    private final int ADD_MODE = 1;
    private final int DELETE_MODE = 2;
    private List<TextArea> textAreas;


    /**
     * Course Database Area
     */
    @FXML
    private TableView<CourseDao> courseDatabaseArea;

    @FXML
    private TableColumn courseIdCol;
    @FXML
    private TableColumn courseNameCol;
    @FXML
    private TableColumn courseDescriptionCol;
    @FXML
    private TableColumn courseTargetClusterCol;
    @FXML
    private TableColumn coursePriceCol;
    @FXML
    private TableColumn courseNoticeCol;
    @FXML
    private TableColumn courseNoteCol;

    /**
     * Course Context Area
     */
    @FXML
    private GridPane courseContextArea;

    @FXML
    private TextArea courseNameText;
    @FXML
    private TextArea coursePriceText;
    @FXML
    private TextArea courseDescriptionText;
    @FXML
    private TextArea courseTargetClusterText;
    @FXML
    private TextArea courseNoticeText;
    @FXML
    private TextArea courseNoteText;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;

    /**
     * Function Button Area
     */
    @FXML
    private GridPane functionBtnArea;
    @FXML
    private Button modifyBtn;
    @FXML
    private Button createBtn;
    @FXML
    private Button deleteBtn;

    /**
     * Initialize data
     * @param location
     * @param resources
     */
    public void initialize(URL location, ResourceBundle resources) {
        pm = new PresentationModel();
        initDatabaseArea();
        componentToList();
        courseContextArea.setDisable(true);
        modifyBtn.setDisable(true);
        deleteBtn.setDisable(true);
    }

    /**
     * The event of click Database table
     */
    @FXML
    private void onDatabasePress() {
        pm.setTargetCourse(courseDatabaseArea.getSelectionModel().getSelectedItem());
        if (pm.isNoTarget())
            return;

        showSelectContent();
        modifyBtn.setDisable(false);
        deleteBtn.setDisable(false);
    }

    @FXML
    private void onTextValueChanged() {
        setTextAreaBtnDisable(false);
    }

    /**
     * The event of click modify button
     */
    @FXML
    private void onModifyBtnClick() {
        setTextAreaEditable(true);
        setTextAreaBackground(WHITE);
        if (pm.getMode() != MODIFY_MODE)
            setTextAreaBtnDisable(true);
        pm.setMode(MODIFY_MODE);
    }

    @FXML
    private void onAddBtnClick() {
        pm.setMode(ADD_MODE);
        pm.setTargetCourse(null);

        clearTextInTextArea();
        setTextAreaEditable(true);
        setTextAreaBackground(WHITE);
        setTextAreaBtnDisable(true);
        modifyBtn.setDisable(true);
        deleteBtn.setDisable(true);
        courseContextArea.setDisable(false);
    }

    @FXML
    private void onDeleteBtnClick() {
        pm.setMode(DELETE_MODE);
        setTextAreaEditable(false);
        setTextAreaBackground(GRAY);
        setTextAreaBtnDisable(false);
    }

    @FXML
    private void onConfirmBtnClick() {
        switch (pm.getMode()) {
            case 0: // modify mode
                modifyModeConfirm();
                break;

            case 1: // add mode
                addModeConfirm();
                break;

            case 2: // delete mode
                deleteModeConfirm();
                break;

            default:
                break;
        }
    }

    @FXML
    private void onCancelBtnClick() {
        switch (pm.getMode()) {
            case 0: // modify mode
                modifyModeCancel();
                break;

            case 1: // add mode
                addModeCancel();
                break;

            case 2: // delete mode
                deleteModeCancel();
                break;

            default:
                break;
        }

    }

    private void initDatabaseArea() {
        data.addAll(pm.getCourseList());

        courseIdCol.setCellValueFactory( new PropertyValueFactory<CourseDao, Integer>("id"));
        courseNameCol.setCellValueFactory( new PropertyValueFactory<CourseDao, String>("name"));
        courseDescriptionCol.setCellValueFactory( new PropertyValueFactory<CourseDao, String>("description"));
        courseTargetClusterCol.setCellValueFactory( new PropertyValueFactory<CourseDao, String>("targetCluster"));
        coursePriceCol.setCellValueFactory( new PropertyValueFactory<CourseDao, Integer>("price"));
        courseNoticeCol.setCellValueFactory( new PropertyValueFactory<CourseDao, String>("courseNotice"));
        courseNoteCol.setCellValueFactory( new PropertyValueFactory<CourseDao, String>("notes"));

        courseDatabaseArea.setItems(data);
    }

    private void componentToList() {
        textAreas = new ArrayList<TextArea>();
        textAreas.add(courseNameText);
        textAreas.add(coursePriceText);
        textAreas.add(courseDescriptionText);
        textAreas.add(courseTargetClusterText);
        textAreas.add(courseNoticeText);
        textAreas.add(courseNoteText);
    }


    private void showSelectContent() {
        CourseDao course = pm.getTargetCourse();
        courseNameText.setText(course.getName());
        coursePriceText.setText(String.valueOf(course.getPrice()));
        courseDescriptionText.setText(course.getDescription());
        courseTargetClusterText.setText(course.getTargetCluster());
        courseNoticeText.setText(course.getCourseNotice());
        courseNoteText.setText(course.getNotes());
        courseContextArea.setDisable(false);
        setTextAreaBackground(GRAY);
        setTextAreaEditable(false);
        setTextAreaBtnDisable(true);
    }

    private void setTextAreaEditable(boolean isEditable) {
        for (TextArea text : textAreas)
            text.setEditable(isEditable);
    }

    private void setTextAreaBackground(String colorCode) {
        for (TextArea text : textAreas)
            text.setStyle("-fx-control-inner-background:" + colorCode + ";");
    }

    private void setTextAreaBtnDisable(boolean isDisable) {
        confirmBtn.setDisable(isDisable);
        cancelBtn.setDisable(isDisable);
    }

    private void clearTextInTextArea() {
        for (TextArea text : textAreas)
            text.setText("");
    }

    private void modifyModeConfirm() {
        if (!preConditionPass())
            return;

        CourseDao course = pm.getTargetCourse();
//        pm.setTargetValue(textAreas);
        fillInDataToCourse(course);
        pm.updateCourse(course);
        setTextAreaBtnDisable(true);
        refreshView();
    }

    private void addModeConfirm() {
        if (!preConditionPass())
            return;

        CourseDao course = new CourseDao(0);
        fillInDataToCourse(course);
        pm.addCourse(course);
        setTextAreaBackground(WHITE);
        setTextAreaBtnDisable(true);
        refreshView();
    }

    private boolean preConditionPass() {
        if (pm.isEmptyString(courseNameText.getText())) {
            courseNameText.setStyle("-fx-border-color:" + RED + ";");
            return false;
        }
        courseNameText.setStyle("-fx-border-color:" + WHITE + ";");

        if (!pm.isNumberLegal(coursePriceText.getText())) {
            coursePriceText.setStyle("-fx-border-color:" + RED + ";");
            return false;
        }
        coursePriceText.setStyle("-fx-border-color:" + WHITE + ";");

        return true;
    }

    private void deleteModeConfirm() {
        pm.deleteCourse();
        refreshView();
    }

    private void fillInDataToCourse(CourseDao course) {
        course.setName(courseNameText.getText());
        course.setPrice(pm.transferToInteger(coursePriceText.getText()));
        course.setDescription(courseDescriptionText.getText());
        course.setTargetCluster(courseTargetClusterText.getText());
        course.setCourseNotice(courseNoticeText.getText());
        course.setNotes(courseNoteText.getText());
    }

    private void modifyModeCancel() {
        showSelectContent();
    }

    private void addModeCancel() {
        clearTextInTextArea();
    }

    private void deleteModeCancel() {
        functionBtnArea.setDisable(false);
        setTextAreaBtnDisable(true);
    }

    private void refreshView() {
        data.removeAll(data);
        data.addAll(pm.getCourseList());
        if (pm.getTargetCourse() == null)
            clearTextInTextArea();
        else
            showSelectContent();
    }
}
