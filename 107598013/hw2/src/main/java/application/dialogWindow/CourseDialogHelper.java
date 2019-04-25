package application.dialogWindow;

import delivery.CourseRequestModel;
import delivery.ObservableCourse;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class CourseDialogHelper {
    private DialogWindowController dialogWindowController;
    private Stage dialogStage;

    public Optional<CourseRequestModel> display(String title) throws IOException {
        initializeDialog();
        dialogStage.setTitle(title);
        dialogStage.showAndWait();
        return dialogWindowController.isConfirm() ? Optional.of(dialogWindowController.getCourse()) : Optional.empty();
    }

    public Optional<CourseRequestModel> display(String title, ObservableCourse course) throws IOException {
        initializeDialog();
        dialogStage.setTitle(title);
        dialogWindowController.setCourse(course);
        dialogStage.showAndWait();
        return dialogWindowController.isConfirm() ? Optional.of(dialogWindowController.getCourse()) : Optional.empty();
    }

    private void initializeDialog() throws IOException {
        final String DEFAULT_TITLE = "Course Application";
        dialogStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dialog.fxml"));
        Parent fxmlRoot = loader.load();
        dialogWindowController = loader.getController();

        Scene scene = new Scene(fxmlRoot);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        dialogStage.setTitle(DEFAULT_TITLE);
        dialogStage.initStyle(StageStyle.UTILITY);
    }
}
