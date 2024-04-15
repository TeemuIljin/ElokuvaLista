/**
 * @author teemuiljin
 * @version 4.3.2024
 * Importit kaikelle tarvittavalle
 *
 */
//perusimportit
package fxElokuva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.application.Platform;

//alertit yms
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//lista
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import fi.jyu.mit.fxgui.*;

/**
 * @author teemuiljin
 * @version 4.3.2024
 * Törkein Kontrolleri!
 */


public class ElokuvaGUIController {

    @FXML private TextField hakukentta;

    @FXML private ListView elokuvatop;

    @FXML private ListView elokuvatop2;

    /**
     * @author teemuiljin
     * @version 4.3.2024
     * Alustetaan lista elokuvatop, johon voi lisätä pelkällä items.add komennolla
     */

    private ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<String> items2 = FXCollections.observableArrayList();

    /**
     * initialize suoritetaan kun gui alustetaan. List view komponentille elokuvatop asetetaan
     * observable list (items) elokuvien tietoja käyttäen. Sitten lisätään elokuvat getElokuvat-metodilla (Elokuvat-luokka) ja
     * tietojaElokuvasta-metodilla (Elokuva-luokasta). kaikki yhdistyy ja tulostuu listaan.
     */

    public void initialize() throws SailoException, IOException {

         ElokuvaMain.kanta.LueElokuvat();
         ElokuvaMain.kanta.LueGenret();

        //listojen asetus
        elokuvatop2.setItems(items2);
        elokuvatop.setItems(items);

        //silmukoilla luku
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            items.add(elokuva.tietojaElokuva());
        }

        for (int i = 0; i < ElokuvaMain.kanta.getGenret().getLkm(); i++)  {
              items2.add(String.valueOf(ElokuvaMain.kanta.getGenret().getGenres().get(i).tietojaGenre()));
        }
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

    @FXML
    private void Fantasia() {
        return;
    }

    /**
     * @author teemuiljin
     * Lopettaa ohjelman (liitetty lopeta nappulaan)
     */
    @FXML
    private void Lopeta() throws SailoException {
        ElokuvaMain.kanta.talletaElokuvat();
        ElokuvaMain.kanta.talletaGenret();
        Platform.exit();
    }

    /**
     * @author teemuiljin
     * Elokuvien lisäys listaan ja mahdollisuus tehdä tietyn genren elokuvia
     * (listan muokkaus)
     */

    @FXML
    private void lisaysleffa() {


        Elokuva hpuusi = new Elokuva("", "9.8", "1", "Toiminta", "1");
        hpuusi = ModalController.showModal(ElokuvalisaaController.class.getResource("Elokuvalisää.fxml"),
                "Lisää elokuva", null,hpuusi );

        ElokuvaMain.kanta.getElokuvalista().lisaa(hpuusi);
        items.add(hpuusi.tietojaElokuva());
    }

    /**
     * @author teemuiljin
     * Genrejen lisäys listaan tehdään myös randomint ja kutsutaan
     * (listan muokkaus)
     */
    @FXML
    private void lisaysgenre() {

        Genre hpuusi2 = new Genre("komedia", "hauskuutta", 1);
        hpuusi2 = ModalController.showModal(GenrelisaaController.class.getResource("Genrelisää.fxml"),
                "Lisää genre", null,hpuusi2 );

        ElokuvaMain.kanta.getGenret().lisaa(hpuusi2);
        items2.add(hpuusi2.tietojaGenre());
    }

    /**
     * @author teemuiljin
     * Elokuvien poisto listasta
     */
    @FXML
    private void poistaElokuva() {
        // Haetaan valittu elokuva listalta
        String selectedElokuva = (String) elokuvatop.getSelectionModel().getSelectedItem();

        // Käydään läpi elokuvat ja etsitään poistettava elokuva
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            if (elokuva.tietojaElokuva().equals(selectedElokuva)) {
                // Poistetaan elokuva listalta
                ElokuvaMain.kanta.getElokuvalista().poista(elokuva);
                items.remove(selectedElokuva);
                break;
            }
        }
    }

    /**
     * @author teemuiljin
     * Elokuvien haku mahdollista
     * (listan muokkaus)
     */
    @FXML
    private void haeElokuva() {
        String hakusana = hakukentta.getText().toLowerCase(); // Hae hakusana tekstikentästä
        items.clear(); // Tyhjennä näytettävä lista

        // Käyn läpi kaikki elokuvat ja lisään ne listaan, jos ne sisältävät hakusanan
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            if (elokuva.tietojaElokuva().toLowerCase().contains(hakusana)) {
                items.add(elokuva.tietojaElokuva());
            }
        }
    }
    @FXML
    private void Tyhjenna() {
        hakukentta.clear();
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            items.add(elokuva.tietojaElokuva());
        }
    }
    @FXML
    private void poistaGenre() {

        String selectedGenre = (String) elokuvatop2.getSelectionModel().getSelectedItem();

        // Käyn läpi elokuvat ja etsitään poistettava elokuva
        for (Genre genre : ElokuvaMain.kanta.getGenret().getGenres()) {
            if (genre.tietojaGenre().equals(selectedGenre)) {
                // Poistan elokuvan listalta
                ElokuvaMain.kanta.getGenret().poista(genre);
                items2.remove(selectedGenre);
                break;
            }
        }
    }

}



