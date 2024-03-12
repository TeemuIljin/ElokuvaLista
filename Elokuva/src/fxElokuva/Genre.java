package fxElokuva;

import java.util.Optional;

/**
 * @author teemuiljin
 * Genre java luokka, johon laitetaan tietoja genreistä, joka haetaan mainiin
 * TÄRKEÄNÄ GENRE-ID
 */
public class Genre {

    /**
     * @author teemuiljin
     * genreille kuvaukset, tunnusnumero ja genre tietysti
     */

    private static int seuraavaID = 1;

    private int uniikkiID;

    private String genrenimi;

    private String genrekuvaus;


    /**
     * @author teemuiljin
     * tehdään genreistä uniikkeja
     */

    public Genre(String genrenimi, String genrekuvaus ){
        this.genrenimi = genrenimi;
        this.genrekuvaus= genrekuvaus;
        this.uniikkiID = seuraavaID++;
    }


    /**
     * @author teemuiljin
     * tekee genrelle kuvauksen ja palauttaa sen merkkijonona ylemmäs genret-luokkaan
     */


    public String tietojaGenre() {
        return " Tiedot: " + genrekuvaus + ", Genre: " + genrenimi +  ", Genren ID: " + uniikkiID ;
    }

}
