package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String TITLE = "Course Application";
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../main.fxml"));
            Parent fxmlRoot = loader.load();
            Scene scene = new Scene(fxmlRoot);
            primaryStage.setScene(scene);
            primaryStage.setTitle(TITLE);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
