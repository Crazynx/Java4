package Oefenopdracht4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

    /*
     * Runner
     * The runner is responsible for running the program. It also sets the title, scene and other attributes.
     */

public class Runner extends Application {

    /*
     * Fallback method
     */
    public static void main (String[] args) {
        launch(args);
    }

    /*
     * This method starts the application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Controller(), 500, 200);
        primaryStage.setTitle("Random name generator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
