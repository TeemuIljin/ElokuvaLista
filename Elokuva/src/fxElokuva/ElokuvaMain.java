package fxElokuva;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;



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

            //luodaan elokuva ja asetetaan sille tietoja
            Elokuva Harri = new Elokuva();
            Harri.name = "Harry Potter";
            Harri.genre_id = 1;
            Harri.imdb = "7.2";
            Harri.length = "2h 35m";
            Elokuva[] lista = new Elokuva[10];
            lista[0] = Harri;
            Elokuva Batman = new Elokuva();
            Batman.name = "Batman 2";
            Batman.genre_id = 2;
            Batman.imdb = "8.9";
            Batman.length = "3h 30min";
            lista[1] = Batman;

            // käydään lista läpi (iteroidaan array)
            // if lauseessa varmistetaan että on tilaa listassa ja että se on olemassa
            for (Elokuva elokuva : lista) {

                    // Tulostetaan tietoja elokuvasta listan alkioista
                    // tällä hetkellä tulostetaan koko lista
                    if (elokuva != null) {
                    System.out.println("Name: " + elokuva.name);
                    System.out.println("Genre ID: " + elokuva.genre_id);
                    System.out.println("IMDb: " + elokuva.imdb);
                    System.out.println("Length: " + elokuva.length);
                    System.out.println(); //ylimääräinen rivi kauneutta varten
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author teemuiljin
     * Tyhjä main. Pelkästään launch
     */

    public static void main(String[] args) {
        launch(args);

    }
}
