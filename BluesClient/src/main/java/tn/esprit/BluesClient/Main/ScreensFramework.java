package tn.esprit.BluesClient.Main;
import tn.esprit.BluesClient.Screeners.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author Maleck
 *
 */
public class ScreensFramework extends Application {
    
    public static String screen1ID = "first";
    public static String screen1File = "first.fxml";
    public static String screen2ID = "article";
    public static String screen2File = "article.fxml";
    public static String screen3ID = "company";
    public static String screen3File = "company.fxml";
    public static String screen4ID = "profile";
    public static String screen4File = "profile.fxml";
    public static String screen5ID = "stats";
    public static String screen5File = "stats.fxml";
    public static String screen6ID = "user";
    public static String screen6File = "user.fxml";
    public static String screen7ID = "login1";
    public static String screen7File = "login.fxml";
    
    public static Stage s;
    
    @Override
    public void start(Stage primaryStage) {
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        mainContainer.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
        mainContainer.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
        mainContainer.loadScreen(ScreensFramework.screen6ID, ScreensFramework.screen6File);
        mainContainer.loadScreen(ScreensFramework.screen7ID, ScreensFramework.screen7File);
       // mainContainer.getStylesheets().add("tn.esprit.BluesClient.Screeners//desktop.css");
        mainContainer.setScreen(ScreensFramework.screen7ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        s=primaryStage;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

