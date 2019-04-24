package view;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import presenter.CoursePresenter;

import java.io.IOException;
import java.util.Optional;

public class CourseController {
    private CoursePresenter coursePresenter;

    @FXML
    private TableView courseTableView;
    @FXML
    private Button editCourseButton;
    @FXML
    private Button deleteCourseButton;
    @FXML
    private final ObservableList<ObservableCourse> courses = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        coursePresenter = new CoursePresenter();
        setButtonDisableProperty(editCourseButton);
        setButtonDisableProperty(deleteCourseButton);
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
        Optional<ObservableCourse> newCourse = new CourseDialog().display(TITLE);
        newCourse.ifPresent(course -> {
            coursePresenter.addCourse(course);
            refreshCourseTableView();
        });
    }

    @FXML
    public void pressEditCourseButton(ActionEvent event) throws IOException {
        final String TITLE = "Edit Course";
        ObservableCourse selectedCourse = getTableSelectedItem();
        Optional<ObservableCourse> editedCourse = new CourseDialog().display(TITLE, selectedCourse);
        editedCourse.ifPresent(course -> {
            course.setId(selectedCourse.getId());
            coursePresenter.editCourse(course);
            refreshCourseTableView();
        });
    }

    @FXML
    public void pressDeleteCourseButton(ActionEvent event) {
        ObservableCourse selectedCourse = getTableSelectedItem();
        coursePresenter.deleteCourse(Integer.valueOf(selectedCourse.getId()));
        refreshCourseTableView();
    }

    private ObservableCourse getTableSelectedItem() {
        ObservableList selected = courseTableView.getSelectionModel().getSelectedItems();
        return selected.size() > 0 ? (ObservableCourse) selected.get(0) : null;
    }

    private void refreshCourseTableView() {
        courseTableView.getItems().clear();
        courseTableView.getItems().addAll(coursePresenter.getAllCourses());
    }
}
