package fxElokuva;

import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import fi.jyu.mit.fxgui.*;

public class ElokuvalisaaController implements ModalControllerInterface<Elokuva> {

    @FXML private TextField nimi;
    @FXML private TextField imdb;
    @FXML private TextField pituus;
    @FXML private ChoiceBox genre;



    public void setDefault(Elokuva oletus) {

    }

    public ChoiceBox getGenre() {
        return genre;
    }

    public void handleShown() {
    }
    public Elokuva getResult() {
        int guid = ElokuvaMain.kanta.getElokuvalista().getElokuvat().size()+1;
        return new Elokuva(nimi.getText(), imdb.getText(), pituus.getText(), "", Integer.toString(guid));
    }

    public void luoElokuva(){
        if (isValidInput()) {
            ModalController.closeStage(nimi);
        } else {
            näytäVirheilmoitus("Virheelliset tiedot", "Syötä oikeanlaiset tiedot ennen elokuvan lisäämistä.");
        }
    }

    private boolean isValidInput() {
        String nimiText = nimi.getText();
        String imdbText = imdb.getText();

        if (nimiText.isEmpty() || imdbText.isEmpty()) {
            // Palautan false, jos nimi tai IMDB-arvo on tyhjä
            return false;
        }

        if (!imdbText.matches("[0-9.]+")) {

            return false;
        }

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