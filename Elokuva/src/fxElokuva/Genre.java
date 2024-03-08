package fxElokuva;

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
    private String genrenimi;

    private String genrekuvaus;

    private int tunnusNro;

    /**
     * @author teemuiljin
     * tehdään genreistä uniikkeja
     */

    public Genre(String genrenimi, String genrekuvaus, int tunnusNro){
        this.genrenimi = genrenimi;
        this.genrekuvaus= genrekuvaus;
        this.tunnusNro= tunnusNro;
    }


    /**
     * @author teemuiljin
     * tekee genrelle kuvauksen ja palauttaa sen merkkijonona ylemmäs genret-luokkaan
     */


    public String tietojaGenre() {
        return " Genren kuvaus: " + genrekuvaus + ", Genren nimi: " + genrenimi +  ", Genren tunnus: " + tunnusNro;
    }
}
