import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Course Management System");
        primaryStage.setScene(new Scene(root, 660, 475));
        primaryStage.setX(50);
        primaryStage.setY(100);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
