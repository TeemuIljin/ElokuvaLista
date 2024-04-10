package fxElokuva;
import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author teemuiljin
 * Genre java luokka, johon laitetaan tietoja genreistä, joka haetaan mainiin (alustan attribuutit)
 * TÄRKEÄNÄ GENRE-ID
 */
public class Genre {


     // genreille kuvaukset, tunnusnumero ja genre tietysti

    private static int seuraavaID = 1;

    private int uniikkiID;

    private String genrenimi;

    private String genrekuvaus;


    /**
     * @author teemuiljin
     * tehdään genreistä uniikkeja 2 konstruktoria
     */

    public Genre(String genrenimi, String genrekuvaus){
        this.genrekuvaus = genrekuvaus;
        this.genrenimi = genrenimi;
        this.uniikkiID = seuraavaID++;
    }
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
     * parse korjattu genreille 31.3
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
     * tostring tehty genreille
     */
    @Override
    public String toString() {
        return genrekuvaus + "|" + genrenimi + "|" + uniikkiID;
    }

    public String getGenrenimi() {
        return genrenimi;
    }

    public int getUniikkiID() {
        return 0;
    }

    public String getGenrekuvaus() {
        return genrekuvaus;
    }
}
