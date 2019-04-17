import com.google.inject.Guice;
import com.google.inject.Injector;
import controller.CourseViewObject;
import controller.FxmlController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import module.Module;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FxView implements Initializable {
    private FxmlController controller;
    private List<TextArea> textAreas;

    private final String GRAY = "#DCDCDC";
    private final String WHITE = "#FFF";
    private final String RED = "#FF0000";
    private final int MODIFY_MODE = 0;
    private final int ADD_MODE = 1;
    private final int DELETE_MODE = 2;

    /**
     * Course Database Area
     */
    @FXML
    private TableView<CourseViewObject> courseDatabaseArea;

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

    private final ObservableList<CourseViewObject> data = FXCollections.observableArrayList();

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
        Injector injector = Guice.createInjector(new Module());
        controller = injector.getInstance(FxmlController.class);
        try {
            loadDataToViews();
        } catch (Exception e) {
            e.printStackTrace();
            setAllToDisable();
        }
    }

    /**
     * The event of click Database table
     */
    @FXML
    private void onDatabasePress() {
        controller.setTargetCourse(getTargetCourse());

        if (controller.isNoTarget())
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
        if (controller.getMode() != MODIFY_MODE)
            setTextAreaBtnDisable(true);
        controller.setMode(MODIFY_MODE);
    }

    @FXML
    private void onAddBtnClick() {
        controller.setMode(ADD_MODE);
        controller.setTargetCourse(null);

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
        controller.setMode(DELETE_MODE);
        setTextAreaEditable(false);
        setTextAreaBackground(GRAY);
        setTextAreaBtnDisable(false);
    }

    @FXML
    private void onConfirmBtnClick() {
        switch (controller.getMode()) {
            case MODIFY_MODE:
                modifyModeConfirm();
                break;

            case ADD_MODE:
                addModeConfirm();
                break;

            case DELETE_MODE:
                deleteModeConfirm();
                break;

            default:
                break;
        }
    }

    @FXML
    private void onCancelBtnClick() {
        switch (controller.getMode()) {
            case MODIFY_MODE: // modify mode
                modifyModeCancel();
                break;

            case ADD_MODE: // add mode
                addModeCancel();
                break;

            case DELETE_MODE: // delete mode
                deleteModeCancel();
                break;

            default:
                break;
        }

    }

    private void setAllToDisable() {
        courseDatabaseArea.setDisable(true);
        courseContextArea.setDisable(true);
        functionBtnArea.setDisable(true);
    }

    private void loadDataToViews() throws Exception {
        initDatabaseArea();
        componentToList();
        courseContextArea.setDisable(true);
        modifyBtn.setDisable(true);
        deleteBtn.setDisable(true);
    }

    private void initDatabaseArea() throws Exception {
        data.addAll(controller.getCourseList());

        courseIdCol.setCellValueFactory( new PropertyValueFactory<CourseViewObject, Integer>("id"));
        courseNameCol.setCellValueFactory( new PropertyValueFactory<CourseViewObject, String>("name"));
        courseDescriptionCol.setCellValueFactory( new PropertyValueFactory<CourseViewObject, String>("description"));
        courseTargetClusterCol.setCellValueFactory( new PropertyValueFactory<CourseViewObject, String>("targetCluster"));
        coursePriceCol.setCellValueFactory( new PropertyValueFactory<CourseViewObject, Integer>("price"));
        courseNoticeCol.setCellValueFactory( new PropertyValueFactory<CourseViewObject, String>("courseNotice"));
        courseNoteCol.setCellValueFactory( new PropertyValueFactory<CourseViewObject, String>("notes"));

        courseDatabaseArea.setItems(data);
    }

    private void componentToList() {
        textAreas = new ArrayList<TextArea>();
        textAreas.add(courseNameText);
        textAreas.add(courseDescriptionText);
        textAreas.add(courseTargetClusterText);
        textAreas.add(coursePriceText);
        textAreas.add(courseNoticeText);
        textAreas.add(courseNoteText);
    }

    private CourseViewObject getTargetCourse() {
        return courseDatabaseArea.getSelectionModel().getSelectedItem();
    }

    private void showSelectContent() {
        CourseViewObject course = controller.getTargetCourse();
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

        try {
            controller.updateCourse(textAreas);
            setTextAreaBtnDisable(true);
            refreshView();
        } catch (Exception e) {
            // TODO add some notice
            e.printStackTrace();
        }
    }

    private void addModeConfirm() {
        if (!preConditionPass())
            return;

        try {
            controller.addCourse(textAreas);
            setTextAreaBackground(WHITE);
            setTextAreaBtnDisable(true);
            refreshView();
        } catch (Exception e) {
            // TODO add some notice
            e.printStackTrace();
        }
    }

    private void deleteModeConfirm() {
        try {
            controller.deleteCourse();
            refreshView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean preConditionPass() {
        if (controller.isEmptyString(courseNameText.getText())) {
            courseNameText.setStyle("-fx-border-color:" + RED + ";");
            return false;
        }
        courseNameText.setStyle("-fx-border-color:" + WHITE + ";");

        if (!controller.isNumberLegal(coursePriceText.getText())) {
            coursePriceText.setStyle("-fx-border-color:" + RED + ";");
            return false;
        }
        coursePriceText.setStyle("-fx-border-color:" + WHITE + ";");

        return true;
    }

    private void modifyModeCancel() {
        showSelectContent();
    }

    private void addModeCancel() {
        clearTextInTextArea();
        courseContextArea.setDisable(true);
    }

    private void deleteModeCancel() {
        functionBtnArea.setDisable(false);
        setTextAreaBtnDisable(true);
    }

    private void refreshView(){
        try {
            data.removeAll(data);
            data.addAll(controller.getCourseList());
            if (controller.getTargetCourse() == null)
                clearTextInTextArea();
            else
                showSelectContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
