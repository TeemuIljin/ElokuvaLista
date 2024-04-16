package fxElokuva;

import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fxElokuva.Elokuva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import fxElokuva.Genre;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * ElokuvalisääController luokka, jossa elokuvalisäyksen tapahtuma suoritetaan uudessa fxml tiedostossa
 * yksi kolmesta controllerista
 */
public class ElokuvalisaaController implements ModalControllerInterface<Elokuva> {

    /**
     * @author teemuiljin
     * Alustukset fxml nappulat käyttöä varten
     */

    @FXML private TextField nimi;
    @FXML private TextField imdb;
    @FXML private TextField pituus;
    @FXML private ChoiceBox<Genre> genre;


    /**
     * @author teemuiljin
     * alustan genret listan ja laitan sinne genret listan
     */
    public void setDefault(Elokuva oletus) {
        //genre.setItems(ElokuvaMain.kanta.getGenret().getGenres());
        ObservableList<Genre> ti = FXCollections.observableArrayList();
        ti = FXCollections.observableList(ElokuvaMain.kanta.getGenret().getGenres());
        genre.setItems(ti);
    }

    public void handleShown() {
    }
    /**
     * @author teemuiljin
     * palautan tiedot, genren id ja uniikin id jokaiselle leffalle
     */

    public Elokuva getResult() {
        int guid = ElokuvaMain.kanta.getElokuvalista().GetLkm() + 1;
        Genre genre1 = genre.getSelectionModel().getSelectedItem();
        String genreID = Integer.toString(genre1.getUniikkiID());
        return new Elokuva(nimi.getText(), imdb.getText(), pituus.getText(), genreID, Integer.toString(guid));
    }
    /**
     * @author teemuiljin
     * failsafe ja virheilmoitus jos ei hyvä, muuten normaali toiminta
     */

    public void luoElokuva(){
        if (isValidInput()) {
            ModalController.closeStage(nimi);
        } else {
            näytäVirheilmoitus("Virheelliset tiedot", "Syötä oikeanlaiset tiedot ennen elokuvan lisäämistä.");
        }
    }
    /**
     * @author teemuiljin
     * Is valid input varmistaa, että input on toimiva ja järkevä
     */

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

    /**
     * @author teemuiljin
     * tekee virheilmoituksen jos tarvittavat ehdot eivät täytä tai jos elokuva on puutteellinen
     * (toimii hyvin)
     */

    private void näytäVirheilmoitus(String otsikko, String viesti) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(otsikko);
        alert.setHeaderText(null);
        alert.setContentText(viesti);
        alert.showAndWait();
    }
}
