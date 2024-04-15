package fxElokuva;

import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import fi.jyu.mit.fxgui.*;

public class GenrelisaaController implements ModalControllerInterface<Genre>{

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

    @Override
    public void setDefault(Genre genre) {
    }

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

    private boolean isValidInput() {
        String nimiText = genrenimi.getText();
        String kuvausText = genrekuvaus.getText();

        if (nimiText.isEmpty() || kuvausText.isEmpty()) {
            return false;
        }

        // Lisää tarkistuksia jos haluan

        return true;
    }
    private void näytäVirheilmoitus(String otsikko, String viesti) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(otsikko);
        alert.setHeaderText(null);
        alert.setContentText(viesti);
        alert.showAndWait();
    }
}
