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
     * alustettu nappulat ja liitettu fxml tiedosto controlleriin
     */
    @Override
    public Genre getResult() {
        return new Genre(genrenimi.getText(), genrekuvaus.getText());
    }

    @Override
    public void setDefault(Genre genre) {

    }

    @Override
    public void handleShown() {

        /**
         * @author teemuiljin
         * Palauttaa luodun genren listaan
         */
    }

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

        // Lisää tarkistuksia tarvittaessa

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
