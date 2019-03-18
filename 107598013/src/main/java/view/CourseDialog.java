package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class CourseDialog {
    private DialogController controller;
    private Stage dialogStage;

    public Optional<ObservableCourse> display(String title) throws IOException {
        initializeDialog();
        dialogStage.setTitle(title);
        dialogStage.showAndWait();
        return controller.isConfirm() ? Optional.of(controller.getCourse()) : Optional.empty();
    }

    public Optional<ObservableCourse> display(String title, ObservableCourse course) throws IOException {
        initializeDialog();
        dialogStage.setTitle(title);
        controller.setCourse(course);
        dialogStage.showAndWait();
        return controller.isConfirm() ? Optional.of(controller.getCourse()) : Optional.empty();
    }

    private void initializeDialog() throws IOException {
        final String DEFAULT_TITLE = "Course Application";
        dialogStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../dialog.fxml"));
        Parent fxmlRoot = loader.load();
        controller = loader.getController();

        Scene scene = new Scene(fxmlRoot);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        dialogStage.setTitle(DEFAULT_TITLE);
        dialogStage.initStyle(StageStyle.UTILITY);
    }
}
