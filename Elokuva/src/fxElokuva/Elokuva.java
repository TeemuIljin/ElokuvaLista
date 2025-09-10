package fxElokuva;

import javafx.scene.Node;

/**
 * Elokuva luokka, jossa tietoja yksittäisestä elokuvasta.
 * 
 * <p>Luokka sisältää elokuvan perustiedot kuten nimen, IMDB-arvon, 
 * pituuden ja genren. Tarjoaa metodit tiedon käsittelyyn ja 
 * tallentamiseen.</p>
 * 
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * @version 2.0
 * @since 1.0
 */

public class Elokuva extends Node {

    // Constants
    private static final String DEFAULT_IMDB = "0.0";
    private static final String DEFAULT_DURATION = "0min";
    private static final String DEFAULT_GENRE = "Unknown";
    
    // Instance variables
    private int uniikkiID;

    /**
     * @author teemuiljin
     * nimen alustus
     */

    private String nimi;

    /**
     * @author teemuiljin
     * imdb alustus
     */

    private String imdb;

    /**
     * @author teemuiljin
     *pituus alustus
     */

    private String pituus;

    /**
     * @author teemuiljin
     * genre alustus
     */

    private String genre;

    /**
     * Konstruktori elokuvan tiedoille.
     * 
     * @param nimi elokuvan nimi
     * @param imdb IMDB-arvo merkkijonona
     * @param pituus elokuvan pituus
     * @param genre genren ID merkkijonona
     * @param id uniikki tunniste merkkijonona
     * @throws NumberFormatException jos id ei ole kelvollinen numero
     */
    public Elokuva(String nimi, String imdb, String pituus, String genre, String id) {
        this.nimi = (nimi != null && !nimi.trim().isEmpty()) ? nimi.trim() : "Unknown";
        this.imdb = (imdb != null && !imdb.trim().isEmpty()) ? imdb.trim() : DEFAULT_IMDB;
        this.pituus = (pituus != null && !pituus.trim().isEmpty()) ? pituus.trim() : DEFAULT_DURATION;
        this.genre = (genre != null && !genre.trim().isEmpty()) ? genre.trim() : DEFAULT_GENRE;
        this.uniikkiID = Integer.parseInt(id);
    }

    /**
     * @author teemuiljin
     * tietoja elokuvista eteenpäin elokvat.javaa varten (käytetään myöhemmin eli kutsutaan ylempänä Elokuvat.java)
     */

    public String tietojaElokuva() {
        return " Nimi: " + nimi +  ", imdb: " + imdb + ", Kesto: " + pituus + ", genre: " + genre + ", ID: " + uniikkiID;
    }
    /**
     * Parse toimii oikein ja pilkkoo tiedoston tekstin
     */

    public static Elokuva parse(String data) {
        String[] parts = data.split("\\|");
        if (parts.length < 5) {

            return null;
        }
        String nimi = parts[0].trim();
        String imdb = parts[1].trim();
        String pituus = parts[2].trim();
        String genreid= parts[3].trim();
        String uniikkiID = parts[4].trim();
        return new Elokuva(nimi, imdb, pituus, genreid, uniikkiID);
    }
    /**
     * Tostring korjattu ja tulostettavan tiedon muoto
     */
    @Override
    public String toString() {
        return nimi + " | " + imdb + " | " + pituus + " | " + genre + " | " + uniikkiID ;
    }

    /**
     * @author teemuiljin
     * testejä varten (toimivat )
     */

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }

    /**
     * @author teemuiljin
     * nimen getteri testejä varten
     */

    public String getNimi() {
        return nimi;
    }

    /**
     * @author teemuiljin
     * imdb getteri testejä varten
     */

    public String getImdb() {
        return imdb;
    }

    /**
     * @author teemuiljin
     * pituusgetteri testejä varten
     */

    public String getPituus() {
        return pituus;
    }

    /**
     * @author teemuiljin
     * genren getteri testejä varten
     */

    public String getGenre() {
        return genre;
    }

    /**
     * @author teemuiljin
     * genreID getteri joka muttaa tietotyypin lakskeimdb varten
     */
    public int getGenreID() {
        return Integer.parseInt(genre);
    }

    /**
     * @author teemuiljin
     * uniikkiID getteri testejä varten
     */

    public int getUniikkiID() {
        return uniikkiID;
    }
}




