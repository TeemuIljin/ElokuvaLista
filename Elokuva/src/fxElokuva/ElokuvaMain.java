package fxElokuva;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

//elokuva
import fxElokuva.Elokuva;




/**
 * @author teemuiljin
 * @version 4.3.2024
 * Mainiin luodaan sisältöä
 * Esimerkiksi lista luodaan ja sen alkioksi asetetaan harri ja sen tietoja
 * Nämä tiedot printataan ohjelman alussa
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
     * @author teemuiljin
     * Tyhjä main. Pelkästään launch
     * Niin kuin pitääkin
     */

    public static void main(String[] args) {
        launch(args);


    }
}
