package pl.project.pk;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BorderPaneMain.fxml"));

        /* Resouce bundle inicialize */
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);

        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);

        primaryStage.setWidth(1200);
        primaryStage.setHeight(800);

        primaryStage.setTitle(bundle.getString("title.application"));
        primaryStage.show();

    }
}
