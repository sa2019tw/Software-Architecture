import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));

        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);

        primaryStage.setTitle("課程管理");
        primaryStage.show();
    }
}
