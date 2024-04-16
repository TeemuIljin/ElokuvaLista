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
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

//lista

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import fi.jyu.mit.fxgui.*;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * ElokuvaGuiController luokka, jossa suurin osa toiminnoista
 * suoritetaan ja kaikki listan toiminta tehdään
 * (EI TARVITSE MAINIA)
 */
public class ElokuvaGUIController {

    /**
     * @author teemuiljin
     * alustetaan fxml osat
     */

    @FXML private TextField hakukentta;

    @FXML private TextField ka;
    @FXML private ListView elokuvatop;

    @FXML private ListView elokuvatop2;

    @FXML private StringGrid<Elokuva> grid;

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
     * teen myös gridin johon lisään silmukalla omiin sarakkeisiin oikeat tiedot.
     */

    public void initialize() throws SailoException, IOException {

         ElokuvaMain.kanta.LueElokuvat();
         ElokuvaMain.kanta.LueGenret();
        elokuvatop2.setItems(items2);

        for (int i = 0; i < ElokuvaMain.kanta.getGenret().getLkm(); i++)  {
              items2.add(String.valueOf(ElokuvaMain.kanta.getGenret().getGenres().get(i).tietojaGenre()));
        }

        String[] headings = {"Nimi","imdb","pituus","genre"};
        grid.initTable(headings);
        grid.setEditable(false);
        //grid.setItems();
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            grid.add(elokuva.getNimi(), elokuva.getImdb(), elokuva.getPituus(), ElokuvaMain.kanta.getGenret().Getgenrenamebyid(elokuva.getGenreID()));
        }
        ka.setText(ElokuvaMain.kanta.getElokuvalista().LaskeImdb());
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
        grid.add(hpuusi.getNimi(), hpuusi.getImdb(), hpuusi.getPituus(), ElokuvaMain.kanta.getGenret().Getgenrenamebyid(hpuusi.getGenreID()));
        ka.setText(ElokuvaMain.kanta.getElokuvalista().LaskeImdb());
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
     * Elokuvien poisto listasta voidaan valita tietty elokuva ja poistetaan tietty
     * tyhjennetään sen jälkeen grid ja lisätään elokuvat silmukalla uudestaan taulukkoon
     */
    @FXML
    private void poistaElokuva() {
        int valittuIndeksi = grid.getRowNr();
        ElokuvaMain.kanta.getElokuvalista().getElokuvat().remove(valittuIndeksi);
        grid.clear();
        for (Elokuva elokuva2 : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            grid.add(elokuva2.getNimi(), elokuva2.getImdb(), elokuva2.getPituus(), ElokuvaMain.kanta.getGenret().Getgenrenamebyid(elokuva2.getGenreID()));
        }
        ka.setText(ElokuvaMain.kanta.getElokuvalista().LaskeImdb());
    }

    /**
     * @author teemuiljin
     * Elokuvien haku mahdollista
     * tyhjentää taulukon, lukee ja lisää tilapäiseen listaan
     * (listan muokkaus)
     */
    @FXML
    private void haeElokuva() {
        String hakusana = hakukentta.getText().toLowerCase(); // Hae hakusana tekstikentästä
        grid.clear(); // Tyhjennä näytettävä lista

        // Käyn läpi kaikki elokuvat ja lisään ne listaan, jos ne sisältävät hakusanan
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            if (elokuva.tietojaElokuva().toLowerCase().contains(hakusana)) {
                grid.add(elokuva.getNimi(), elokuva.getImdb(), elokuva.getPituus(), ElokuvaMain.kanta.getGenret().Getgenrenamebyid(elokuva.getGenreID()));
                //grid.add(elokuva.tietojaElokuva());
            }
        }
    }
    /**
     * @author teemuiljin
     * Tyhjentää tilapäisen listan
     */
    @FXML
    private void Tyhjenna() {
        hakukentta.clear();
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            //grid.add(elokuva.tietojaElokuva());
            grid.add(elokuva.getNimi(), elokuva.getImdb(), elokuva.getPituus(), ElokuvaMain.kanta.getGenret().Getgenrenamebyid(elokuva.getGenreID()));
        }
    }

    /**
     * @author teemuiljin
     * Poistaa valitun genren listasta
     */

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



