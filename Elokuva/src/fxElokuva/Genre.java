package fxElokuva;
import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Genre java luokka, johon laitetaan tietoja genreistä, joka haetaan mainiin
 * TÄRKEÄNÄ GENRE-ID
 */
public class Genre {

    /**
     * @author teemuiljin
     * seuraavaID alustus
     */
    private static int seuraavaID = 1;
    /**
     * @author teemuiljin
     * uniikkiID alustus
     */
    private int uniikkiID;

    /**
     * @author teemuiljin
     * alustetaan genrenimi
     */

    private String genrenimi;

    /**
     * @author teemuiljin
     * alustetaan genrenkuvaus
     */
    private String genrekuvaus;


    /**
     * @author teemuiljin
     * tehdään genreistä uniikkeja konstruktorien avulla
     */

    public Genre(String genrenimi, String genrekuvaus){
        this.genrekuvaus = genrekuvaus;
        this.genrenimi = genrenimi;
        this.uniikkiID = seuraavaID++;
    }
    /**
     * @author teemuiljin
     * tehdään genreistä uniikkeja konstruktorien avulla
     */
    public Genre(String genrenimi, String genrekuvaus, int uniikkiID){
        this.genrekuvaus = genrekuvaus;
        this.genrenimi = genrenimi;
        this.uniikkiID = uniikkiID;
    }
    /**
     * @author teemuiljin
     * tekee genrelle kuvauksen ja palauttaa sen merkkijonona ylemmäs genret-luokkaan
     * eli tostring!
     */
    public String tietojaGenre() {
        return " Tiedot: " + genrekuvaus + ", Genre: " + genrenimi +  ", Genren ID: " + uniikkiID ;
    }

    /**
     * @author teemuiljin
     * parse korjattu genreille pilkkoo genren tiedot ja palauttaa siististi
     */

    public static Genre parse(String data) {
        String[] parts = data.split("\\|");
        if (parts.length < 3) {
            // Not enough parts to represent a valid movie, return null or throw exception
            return null; // or throw an exception
        }
        String genrekuvaus = parts[0].trim();
        String genrenimi = parts[1].trim();
        String uniikkiID = parts[2].trim();
        int id = Integer.parseInt(uniikkiID);
        return new Genre(genrekuvaus, genrenimi, id); // Notice that the genre attribute is left empty here
    }

    /**
     * @author teemuiljin
     * tostring tehty genreille yhdistää tiedot hyvin
     */
    @Override
    public String toString() {
        return genrekuvaus + "|" + genrenimi + "|" + uniikkiID;
    }

    /**
     * @author teemuiljin
     * getterit muualle genrenimi getteri
     */
    public String getGenrenimi() {
        return genrenimi;
    }

    /**
     * @author teemuiljin
     * get uniikkiID testeille
     */
    public int getUniikkiID() {
        return uniikkiID;
    }

    /**
     * @author teemuiljin
     * get genrekuvaus testeille
     */
    public String getGenrekuvaus() {
        return genrekuvaus;
    }
}
