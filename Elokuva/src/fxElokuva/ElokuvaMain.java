package fxElokuva;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author teemuiljin
 * @version 13.2.2024
 */
public class ElokuvaMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("ElokuvaGUIView.fxml"));
            final Pane root = ldr.load();
            //final ElokuvaGUIController elokuvaCtrl = (ElokuvaGUIController)ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("elokuva.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Elokuva");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        launch(args);
    }
}