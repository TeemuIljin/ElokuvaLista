package fxElokuva;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author teemuiljin
 * Elokuva luokka, jossa tietoja yksittäisestä elokuvasta
 * (EI TARVITSE MAINIA)
 */

public class Elokuva {

    /**
     * @author teemuiljin
     * Ensin alustetaan tiedot elokuville (attribuutit)
     */

    private static int seuraavaID = 1;

    private int uniikkiID;

    private String nimi;

    private String imdb;

    private String pituus;

    private String genre;

    public Elokuva(String nimi, String imdb, String pituus, String genre, int id) {
        this.nimi = nimi;
        this.genre = genre;
        this.imdb = imdb;
        this.pituus = pituus;
        this.uniikkiID = id;
    }

    public int getUniikkiID() {
        return uniikkiID;
    }

    /**
     * @author teemuiljin
     * Konstruktori jotta ei sekotu ja koodi toimii (linkkausta varten listalle)
     */
    public Elokuva(String selectedGenre, String nimi, String imdb, String kenTietää){
        this.nimi = nimi;
        this.genre = selectedGenre;
        this.imdb = imdb;
        this.pituus = kenTietää;
        this.uniikkiID = seuraavaID++;

    }

    /**
     * @author teemuiljin
     * TÄRKEÄÄ!
     * Normi konstruktori, jossa elokuva alustetaan käyttöä varten ja tehdään niistä uniikkeja kutsua varten
     */

    public Elokuva(int genre, String nimi, String imdb, String pituus){
        this.nimi = nimi;
        this.imdb = imdb;
        this.genre = "";
        this.pituus = pituus;
        this.uniikkiID = seuraavaID++;
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
        String ID = parts[3].trim();
        int id = Integer.parseInt(ID);
        return new Elokuva(nimi, imdb, pituus, "", id); // Notice that the genre attribute is left empty here
    }



    /**
     * Tostring tehty 19.3
     */
    @Override
    public String toString() {
        return nimi + " | " + imdb + " | " + pituus + " | " + "1" + " | " + uniikkiID ;
    }
}




