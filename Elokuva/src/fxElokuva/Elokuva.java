package fxElokuva;

/**
 * @author teemuiljin
 * Genre java luokka, johon laitetaan tietoja genreistä, joka haetaan ELOKUVAT LUOKKAAT
 * TÄRKEÄNÄ GENRE-ID
 * (EI TARVITSE MAINIA)
 */

public class Elokuva {

    /**
     * @author teemuiljin
     * Ensin alustetaan tiedot elokuville
     */

    private int genre_id;

    private String nimi;

    private String imdb;

    private String pituus;

    /**
     * @author teemuiljin
     * luodaan myös tunnusnumero ja seuraavanro
     */

    private static int seuraavaVapaa = 1;
    private int tunnusNro;

    /**
     * @author teemuiljin
     * Jotta ei sekotu ja koodi toimii
     */
    public Elokuva(){

    }

    /**
     * @author teemuiljin
     * TÄRKEÄÄ!
     * elokuva alustetaan käyttöä varten ja tehdään niistä uniikkeja kutsua varten
     */

    public Elokuva(int genre_id, String nimi, String imdb, String pituus){
        this.nimi = nimi;
        this.genre_id = genre_id;
        this.imdb = imdb;
        this.pituus = pituus;
    }

    /**
     * @author teemuiljin
     * tietoja elokuvista eteenpäin elokvat.javaa varten
     */


    public String tietojaElokuva() {
        return " Nimi: " + nimi + ", Genre: " + genre_id + ", imdb: " + imdb + ", Kesto: " + pituus;
    }
}




