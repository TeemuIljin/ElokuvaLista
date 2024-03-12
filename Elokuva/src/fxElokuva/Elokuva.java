package fxElokuva;

/**
 * @author teemuiljin
 * Elokuva luokka, jossa tietoja yksittäisestä elokuvasta
 * (EI TARVITSE MAINIA)
 */

public class Elokuva {

    /**
     * @author teemuiljin
     * Ensin alustetaan tiedot elokuville (5 attribuuttia)
     */

    private static int seuraavaID = 1;

    private int uniikkiID;

    private String nimi;

    private String imdb;

    private String pituus;

    private String genre;

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
}




