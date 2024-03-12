/**
 * @author teemuiljin
 * @version 4.3.2024
 * Importit kaikelle tarvittavalle
 *
 */
//perusimportit
package fxElokuva;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import java.awt.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;

//alertit yms
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.swing.*;
import javax.xml.namespace.QName;

//lista
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;


//ohjelmat
import fxElokuva.Elokuvat;
import fxElokuva.Elokuva;
import fxElokuva.ElokuvaMain;




/**
 * @author teemuiljin
 * @version 4.3.2024
 * Kontrolleri, jossa on nappuloiden toiminnot omissa ohjelmissaan
 * Kaikki ohjelmat kommentoitu
 */
public class ElokuvaGUIController {


    //listview alustetaan

    @FXML private ListView elokuvatop;

    @FXML private ListView elokuvatop2;

    /**
     * @author teemuiljin
     * Otetaan listat alemmista luokista guihin, että käyttö mahdollista (Elokuvat ja Genret)
     */
    private Elokuvakanta Ekanta = new Elokuvakanta();

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

    public void initialize() {

        // Asetan lista Listviewiin
        elokuvatop.setItems(items);
        items.add(Ekanta.getElokuvalista().getElokuvat()[0].tietojaElokuva());
        items.add(Ekanta.getElokuvalista().getElokuvat()[1].tietojaElokuva());
        items.add(Ekanta.getElokuvalista().getElokuvat()[2].tietojaElokuva());
        items.add(Ekanta.getElokuvalista().getElokuvat()[3].tietojaElokuva());

        // Asetan genret lista Liesviewiin
        elokuvatop2.setItems(items2);
        items2.add(Ekanta.getGenret().getGenre()[0].tietojaGenre());
        items2.add(Ekanta.getGenret().getGenre()[1].tietojaGenre());
        items2.add(Ekanta.getGenret().getGenre()[2].tietojaGenre());
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
    private void Lopeta() {
        Platform.exit();
    }

     /**
     * @author teemuiljin
     * Automoitu toiminta mutta nappuloilla
     */

    //@FXML
    //private void nappulanPainallus() {
        // Luodaan uusi alertti-ikkuna
        //Alert alert = new Alert(AlertType.INFORMATION);
       // alert.setTitle("Elokuvan tiedot");
       // alert.setHeaderText(null);
       // alert.setContentText("Pituus: 2h 35min\nIMDB: 8.2\nGenre: kauhu");
       // alert.setContentText(elokuvalista.getElokuvat()[0].tietojaElokuva());

        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        //alert.showAndWait();

    /**
     * @author teemuiljin
     * jokaiselle top elokuvalle oma nappi
     * yhteensä 4 nappia 4 top elokuvaa
     */
    //@FXML
    //private void nappulanPainallus2() {
        // Luodaan uusi alertti-ikkuna
        //Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("Elokuvan tiedot");
        //alert.setHeaderText(null);
        // alert.setContentText("Pituus: 2h 35min\nIMDB: 8.2\nGenre: kauhu");
        //alert.setContentText(elokuvalista.getElokuvat()[1].tietojaElokuva());

        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        //alert.showAndWait();


    /**
     * @author teemuiljin
     * Automoitu toiminta vaihetta 5 varten
     * jokaiselle top elokuvalle oma nappi
     * yhteensä 4 nappia 4 top elokuvaa
     */
    //@FXML
    //private void nappulanPainallus3() {
        // Luodaan uusi alertti-ikkuna
        //Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("Elokuvan tiedot");
        //alert.setHeaderText(null);
        // alert.setContentText("Pituus: 2h 35min\nIMDB: 8.2\nGenre: kauhu");
        //alert.setContentText(elokuvalista.getElokuvat()[2].tietojaElokuva());

        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        //alert.showAndWait();

    /**
     * @author teemuiljin
     * Automoitu toiminta vaihetta 5 varten
     * jokaiselle top elokuvalle oma nappi
     * yhteensä 4 nappia 4 top elokuvaa
     */
    //@FXML
    //private void nappulanPainallus4() {
        // Luodaan uusi alertti-ikkuna
        //Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("Elokuvan tiedot");
        //alert.setHeaderText(null);
        // alert.setContentText("Pituus: 2h 35min\nIMDB: 8.2\nGenre: kauhu");
        //alert.setContentText(elokuvalista.getElokuvat()[3].tietojaElokuva());
        // Näytetään alertti-ikkuna ja odotetaan, että käyttäjä sulkee sen
        //alert.showAndWait();

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
        TextInputDialog dialog = new TextInputDialog("Lisää elokuva");
        dialog.setHeaderText(null);
        dialog.setTitle("Vastaa");
        dialog.setContentText("Elokuvan nimi:");
        Optional<String> answer = dialog.showAndWait();
        System.out.println(answer.isPresent() ? answer.get() : "Ei ollut vastausta");

        // hakee valitun genren elokuvatop2 listasta
        String selectedGenre = (String) elokuvatop2.getSelectionModel().getSelectedItem();

        // luo uuden elokuvan sillä genre-id:llä
        Elokuva hpuusi = new Elokuva(selectedGenre, answer.orElse(""), "?", "ken tietää");

        // lisää uuden leffan listaan
        Ekanta.getElokuvalista().lisaa(hpuusi);
        items.add(hpuusi.tietojaElokuva());
    }




    /**
     * @author teemuiljin
     * Genrejen lisäys listaan tehdään myös randomint ja kutsutaan
     * (listan muokkaus)
     */
    @FXML
    private void lisays2() {
        TextInputDialog dialog = new TextInputDialog("Genre");
        dialog.setHeaderText(null);
        dialog.setTitle("Vastaa");
        dialog.setContentText("Genresi nimi:");
        Optional<String> answer = dialog.showAndWait();
        System.out.println(answer.isPresent() ?
                answer.get() : "Ei ollut vastausta");




        Genre hpuusi2 = new Genre(answer.toString(), "?");
        Ekanta.getGenret().lisaa(hpuusi2);
        items2.add(hpuusi2.tietojaGenre());
    }





    /**
     * @author teemuiljin
     * Elokuvien poisto listasta (ei vielä tehty)
     * (listan muokkaus)
     */
    @FXML
    private void poisto() {
    }

    // Tämä metodi liitetään nappiin, jotta se tulostaa valitun elokuvan tiedot






}



