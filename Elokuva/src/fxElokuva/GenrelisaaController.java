package fxElokuva;

import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import fi.jyu.mit.fxgui.*;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * GenrelisääController luokka, jonka avulla avataan uusi fxml genren lisäyksiä varten
 * kaikki tarvittava kysytään käyttäjältä ja kaikki ominaisuudet löytyvät esim failsafe ja näytävirheilmoitus
 */
public class GenrelisaaController implements ModalControllerInterface<Genre>{

    /**
     * @author teemuiljin
     * alustan nappulat fxml
     */
    @FXML private TextField genrekuvaus;
    @FXML private TextField genrenimi;

    /**
     * @author teemuiljin
     * palautan tiedot genreille
     */
    @Override
    public Genre getResult() {
        int guid = ElokuvaMain.kanta.getGenret().getGenres().size() + 1;
        return new Genre(genrenimi.getText(), genrekuvaus.getText(), guid);
    }

    /**
     * @author teemuiljin
     * pakollinen setdefault
     */
    @Override
    public void setDefault(Genre genre) {
    }

    /**
     * @author teemuiljin
     * pakollinen handleshown
     */
    @Override
    public void handleShown() {
    }

    /**
     * @author teemuiljin
     * failsafe ja virheilmoitus
     */
    public void luoGenre(){
        if (isValidInput()) {
            ModalController.closeStage(genrekuvaus);
        } else {
            näytäVirheilmoitus("Virheelliset tiedot", "Syötä oikeanlaiset tiedot ennen genren lisäämistä.");
        }
    }
    /**
     * @author teemuiljin
     * isvalidinput tarkastaa onko syöte valid. jos on niin normaalisti, jos ei niin
     * näyttää virheilmoituksen
     */

    private boolean isValidInput() {
        String nimiText = genrenimi.getText();
        String kuvausText = genrekuvaus.getText();
        if (nimiText.isEmpty() || kuvausText.isEmpty()) {
            return false;
        }
        return true;
    }
    /**
     * @author teemuiljin
     * tässä miltä virheilmoitus näyttää
     */

    private void näytäVirheilmoitus(String otsikko, String viesti) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(otsikko);
        alert.setHeaderText(null);
        alert.setContentText(viesti);
        alert.showAndWait();
    }
}
