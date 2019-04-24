import Controller.Controller;
import Dao.MockCourseDao;
import UseCase.UseCaseFactory;
import View.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
            Parent root = loader.load();
            View view = loader.getController();
//            loader.setController(new Controller(new UseCaseDistributor(new MockCourseDao()), new Presenter(new ViewModel())));
            loader.setController(new Controller(new UseCaseFactory(new MockCourseDao())));
            view.initialize(loader.getController());

            primaryStage.setTitle("Course Management System");
            primaryStage.setScene(new Scene(root, 660, 475));
            primaryStage.setX(50);
            primaryStage.setY(100);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
