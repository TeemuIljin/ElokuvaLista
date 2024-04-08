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
import java.util.Optional;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import fi.jyu.mit.fxgui.*;



//ohjelmat

/**
 * @author teemuiljin
 * @version 4.3.2024
 * Kontrolleri, jossa on nappuloiden toiminnot omissa ohjelmissaan
 * Kaikki ohjelmat kommentoitu
 */


public class ElokuvaGUIController {


    //listview alustetaan
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
       for (int i = 0; i < ElokuvaMain.kanta.getElokuvalista().GetLkm(); i++)  {
             items.add(String.valueOf(ElokuvaMain.kanta.getElokuvalista().getElokuvat()[i].tietojaElokuva()));
       }

        for (int i = 0; i < ElokuvaMain.kanta.getGenret().getLkm(); i++)  {
              items2.add(String.valueOf(ElokuvaMain.kanta.getGenret().getGenre()[i].tietojaGenre()));
        }

    }


    /**
     * @author teemuiljin
     * En ole vielä päättänyt miten teen yötilan
     * Väri vaihtuu valkoiseksi mustasta
     */
    @FXML
    private void paivatila() {

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
    @FXML
    private void Lopeta() throws SailoException {
        ElokuvaMain.kanta.talletaElokuvat();
        ElokuvaMain.kanta.talletaGenret();
        Platform.exit();
    }


    /**
     * @author teemuiljin
     * Kauhu genrelle oma luokka
     * näyttää vain kauhu genre-id elokuvat
     * (liitetty kauhu-nappiin scenessä)
     */

    @FXML
    private void Kauhu() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Kauhun tiedot");
        alert.setHeaderText(null);

        // Näyttää alertin
        alert.showAndWait();
    }

    /**
     * @author teemuiljin
     * Fantasia genrelle oma luokka
     * näyttää vain fantasia genre-id elokuvat
     * (liitetty fantasia-nappiin scenessä)
     */

    @FXML
    private void Fantasia() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fantasian tiedot");
        alert.setHeaderText(null);

        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        alert.showAndWait();
    }

    /**
     * @author teemuiljin
     * Toiminta genrelle oma luokka
     * näyttää vaan toiminta genre-id elokuvat
     * (liitetty toiminta-nappiin scenessä)
     */

    @FXML
    private void Toiminta() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Toiminnan tiedot");
        alert.setHeaderText(null);

        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        alert.showAndWait();
    }

    /**
     * @author teemuiljin
     * Elokuvien lisäys listaan ja mahdollisuus tehdä tietyn genren elokuvia
     * (listan muokkaus)
     */

    @FXML
    private void lisaysleffa() {

        Elokuva hpuusi = new Elokuva("", "9.8", "1", "");
        hpuusi = ModalController.showModal(ElokuvalisaaController.class.getResource("Elokuvalisää.fxml"),
                "Lisää elokuva", null,hpuusi );
        //TextInputDialog dialog = new TextInputDialog("Lisää elokuva");
        //dialog.setHeaderText(null);
        //dialog.setTitle("Vastaa");
        //dialog.setContentText("Elokuvan nimi:");
        //Optional<String> answer = dialog.showAndWait();
        //System.out.println(answer.isPresent() ? answer.get() : "Ei ollut vastausta");

        // hakee valitun genren elokuvatop2 listasta
        //String selectedGenre = (String) elokuvatop2.getSelectionModel().getSelectedItem();

        // luo uuden elokuvan sillä genre-id:llä
        //Elokuva hpuusi = new Elokuva(selectedGenre, answer.orElse(""), "9.8", "1");

        // lisää uuden leffan listaan (ekannan kautta)
        //ElokuvaMain.kanta.getElokuvalista().lisaa(hpuusi);
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

        //TextInputDialog dialog = new TextInputDialog("Genre");
        //dialog.setHeaderText(null);
        //dialog.setTitle("Vastaa");
        //dialog.setContentText("Genresi nimi:");
        //Optional<String> answer = dialog.showAndWait();
        //System.out.println(answer.isPresent() ?
                //answer.get() : "Ei ollut vastausta");



        //Ekannan kautta guihin
        //Genre hpuusi2 = new Genre(answer.toString(), "Genresi kuvaus");
        //ElokuvaMain.kanta.getGenret().lisaa(hpuusi2);
        items2.add(hpuusi2.tietojaGenre());
    }

    /**
     * @author teemuiljin
     * Elokuvien poisto listasta 2.4
     * (listan muokkaus)
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
                break; // Poistetaan vain yksi elokuva, jos niitä olisi useampia
            }
        }
    }

    /**
     * @author teemuiljin
     * Elokuvien haku mahdollista 2.4
     * (listan muokkaus)
     */

    @FXML
    private void haeElokuva() {
        String hakusana = hakukentta.getText().toLowerCase(); // Hae hakusana tekstikentästä
        items.clear(); // Tyhjennä näytettävä lista

        // Käy läpi kaikki elokuvat ja lisää ne listaan, jos ne sisältävät hakusanan
        for (Elokuva elokuva : ElokuvaMain.kanta.getElokuvalista().getElokuvat()) {
            if (elokuva.tietojaElokuva().toLowerCase().contains(hakusana)) {
                items.add(elokuva.tietojaElokuva());
            }
        }
    }

}



