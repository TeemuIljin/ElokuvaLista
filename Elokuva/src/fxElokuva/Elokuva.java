package fxElokuva;

import javafx.scene.Node;

/**
 * @author teemuiljin
 * Elokuva luokka, jossa tietoja yksittäisestä elokuvasta
 * (EI TARVITSE MAINIA)
 */

public class Elokuva extends Node {

    /**
     * @author teemuiljin
     * Ensin alustetaan tiedot elokuville (attribuutit)
     */

    private int uniikkiID;

    private String nimi;

    private String imdb;

    private String pituus;

    private String genre;

    public Elokuva(String nimi, String imdb, String pituus, String genre, String id) {
        this.nimi = nimi;
        this.genre = genre;
        this.imdb = imdb;
        this.pituus = pituus;
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
     * Parse korjattu 31.3
     */
    public static Elokuva parse(String data) {
        String[] parts = data.split("\\|");
        if (parts.length < 5) {
            // Not enough parts to represent a valid movie, return null or throw exception
            return null; // or throw an exception
        }
        String nimi = parts[0].trim();
        String imdb = parts[1].trim();
        String pituus = parts[2].trim();
        String genreid= parts[3].trim();
        String uniikkiID = parts[4].trim();
        return new Elokuva(nimi, imdb, pituus, genreid, uniikkiID); // Notice that the genre attribute is left empty here
    }

    /**
     * Tostring korjattu 2.4
     */
    @Override
    public String toString() {
        return nimi + " | " + imdb + " | " + pituus + " | " + genre + " | " + uniikkiID ;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }

    public String getNimi() {
        return nimi;
    }

    public String getImdb() {
        return imdb;
    }

    public String getPituus() {
        return pituus;
    }

    public String getGenre() {
        return genre;
    }

    public int getUniikkiID() {
        return uniikkiID;
    }
}




