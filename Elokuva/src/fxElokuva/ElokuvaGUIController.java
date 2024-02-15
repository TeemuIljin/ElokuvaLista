package fxElokuva;
import javafx.fxml.FXML;
import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;

/**
 * @author teemuiljin
 * @version 13.2.2024
 */
public class ElokuvaGUIController {
    // TODO
    @FXML private void Nappula() {
        Dialogs.showMessageDialog("Pituus: 2h 35min, imdb: 8.2, Genre:  kauhu");
    }
    @FXML private void Asetukset() {
        Dialogs.showMessageDialog("Help: lisää ja poista jäseniä painamalla lisää/poista jäseniä. Hae hakukentän avulla tiettyjä elokuvia tietokannasta. Paina genrejä nähdäksesi sen genren elokuvia");
    }
    @FXML private void Kauhu() {
        Dialogs.showMessageDialog("Näyttää kauhuelokuvat");
    }
    @FXML private void Fantasia() {
        Dialogs.showMessageDialog("Näyttää fantasiaelokuvat");
    }
    @FXML private void Toiminta() {
        Dialogs.showMessageDialog("Näyttää toimintaelokuvat");
    }
    @FXML private void lisäys() {
        Dialogs.showMessageDialog("Emme osaa lisätä tai poistaa elokuvia");
    }

}

