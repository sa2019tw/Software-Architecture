package application;

import application.exceptionWindow.ExceptionWindowController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springConfig.AppConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CourseApplication extends Application {
    private ApplicationContext context;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public void start(Stage primaryStage) {
        Thread.setDefaultUncaughtExceptionHandler(CourseApplication::showError);

        String TITLE = "Course Application";
        primaryStage.setScene(getMainWindow());
        primaryStage.setTitle(TITLE);
        primaryStage.show();
    }

    private Scene getMainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainWindow/main.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent fxmlRoot = loader.load();
            return new Scene(fxmlRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void showError(Thread t, Throwable e) {
        if (Platform.isFxApplicationThread()) {
            showErrorDialog(e);
            exit();
        } else {
            System.err.println("An unexpected error occurred in " + t);
        }
    }

    private static void showErrorDialog(Throwable e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Exception Trace: ");
        try {
            FXMLLoader loader = new FXMLLoader(CourseApplication.class.getResource("exceptionWindow/exception.fxml"));
            Parent pane = loader.load();
            ((ExceptionWindowController) loader.getController()).setMessage(getStacktrace(e));
            alert.getDialogPane().setExpandableContent(pane);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        alert.showAndWait();
    }

    private static String getStacktrace(Throwable e) {
        StringWriter errorMsg = new StringWriter();
        e.printStackTrace(new PrintWriter(errorMsg));
        return errorMsg.toString();
    }

    private static void exit() {
        Platform.exit();
        System.exit(0);
    }
}
