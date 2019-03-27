package Contorller;


import DAO.MockCourseDAO;
import Entity.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ICourseService;
import service.CourseService;

public class Controller {

    private ICourseService courseService = new CourseService(new MockCourseDAO());

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
    public TableView<Course> courseListTable = new TableView<>();;

    @FXML
    public TableColumn<Course, String> courseNameColumn = new TableColumn<>();

    @FXML
    public TableColumn<Course, String> courseDescriptionColumn = new TableColumn<>();

    @FXML
    public TableColumn<Course, String> courseTargetColumn = new TableColumn<>();

    @FXML
    public TableColumn<Course, String> coursePriceColumn = new TableColumn<>();

    @FXML
    public TableColumn<Course, String> courseAttentionColumn = new TableColumn<>();

    @FXML
    public TableColumn<Course, String> courseRemarkColumn = new TableColumn<>();

    public void initialize() {
        refresh();
    }

    public void addButtonClicked () {
        checkPriceEmpty();
        Course course = new Course(courseName.getText(), courseDescription.getText(), courseTarget.getText(), Integer.parseInt(coursePrice.getText()), courseAttention.getText(), courseRemark.getText());
        courseService.addCourse(course);
        refresh();
        clearInputBox();
    }

    public void retrieveButtonClicked () {
        if(!courseName.getText().isEmpty()){
            Course course = courseService.retrieveOneCourse(courseName.getText());
            courseDescription.setText(course.getCourseDescription());
            courseTarget.setText(course.getCourseTarget());
            coursePrice.setText(String.valueOf(course.getCoursePrice()));
            courseAttention.setText(course.getCourseAttention());
            courseRemark.setText(course.getCourseRemark());
        }
    }

    public void updateButtonClicked () {
        if(!courseName.getText().isEmpty()) {
            checkPriceEmpty();
            Course course = new Course(courseName.getText(), courseDescription.getText(), courseTarget.getText(), Integer.parseInt(coursePrice.getText()), courseAttention.getText(), courseRemark.getText());
            courseService.updateCourse(course);
            refresh();
            clearInputBox();
        }
    }

    public void deleteButtonClicked () {
        if(!courseName.getText().isEmpty()) {
            courseService.deleteCourse(courseName.getText());
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

    private ObservableList<Course> getCourseList() {
        ObservableList<Course> courseList = FXCollections.observableArrayList();
        courseList.addAll(courseService.retrieveAllCourse());
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
