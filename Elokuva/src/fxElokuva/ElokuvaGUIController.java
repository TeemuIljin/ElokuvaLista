/**
 * @author teemuiljin
 * @version 4.3.2024
 * Importit kaikelle tarvittavalle
 *
 */
//perusimportit
package fxElokuva;
import javafx.fxml.FXML;
import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import java.awt.*;
import javafx.application.Platform;

//alertit yms
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @author teemuiljin
 * @version 4.3.2024
 * Kontrolleri, jossa on nappuloiden toiminnot omissa ohjelmissaan
 * Kaikki ohjelmat kommentoitu
 */
public class ElokuvaGUIController {

    /**
     * @author teemuiljin
     * En ole vielä päättänyt miten teen yötilan
     * Väri vaihtuu valkoiseksi mustasta
     */
    @FXML private void paivatila() {

    }
    /**
     * @author teemuiljin
     * Asetukset tehty valmiiksi alert ikkunan avulla eikä dialogpanejen avulla
     * näyttää kaiken tarvittavan tiedon
     */
    @FXML
    private void Asetukset() {
        // Luodaan uusi alertti-ikkuna
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Asetukset");
        alert.setHeaderText(null);
        alert.setContentText("-Lisää ja poista jäseniä painamalla lisää/poista jäseniä.              -Hae hakukentän avulla tiettyjä elokuvia tietokannasta. " +
                "       -Paina genrejä nähdäksesi sen genren elokuvia.");
        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        alert.showAndWait();
    }
    /**
     * @author teemuiljin
     * Lopettaa ohjelman (liitetty lopeta nappulaan)
     */
    @FXML private void Lopeta() {
        Platform.exit();

    }

    /**
     * @author teemuiljin
     * Vaihetta 4 varten nappulanpainallus
     * kaikki napit tulostavat manuaalisesti tuloksen alert ikkunaan
     * (liitetty kaikkiin top elokuviin scenen kautta)
     */
    @FXML
    private void nappulanPainallus() {
        // Luodaan uusi alertti-ikkuna
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Elokuvan tiedot");
        alert.setHeaderText(null);
        alert.setContentText("Pituus: 2h 35min\nIMDB: 8.2\nGenre: kauhu");

        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        alert.showAndWait();
    }
    /**
     * @author teemuiljin
     * Kauhu genrelle oma luokka
     * näyttää vain kauhu genre-id elokuvat
     */
    @FXML private void Kauhu() {
        Dialogs.showMessageDialog("Näyttää kauhuelokuvat");
    }
    /**
     * @author teemuiljin
     * Fantasia genrelle oma luokka
     * näyttää vain fantasia genre-id elokuvat
     */
    @FXML private void Fantasia() {
        Dialogs.showMessageDialog("Näyttää fantasiaelokuvat");
    }
    /**
     * @author teemuiljin
     * Toiminta genrelle oma luokka
     * näyttää vaan toiminta genre-id elokuvat
     */
    @FXML private void Toiminta() {

    }
    /**
     * @author teemuiljin
     * Elokuvien lisäys listaan
     * (listan muokkaus)
     */
    @FXML private void lisays() {

    }
    /**
     * @author teemuiljin
     * Elokuvien poisto listasta
     * (listan muokkaus)
     */
    @FXML private void poisto() {

    }


}

