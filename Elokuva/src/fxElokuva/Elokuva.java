package fxElokuva;


/**
 * @author teemuiljin
 * Elokuva luokka javassa josta tiedot viedään pääohjelmalle Mainiin
 * Vietäviä tietoja mainiin nimi,imdb, pituus ja genre-id
 * tietenkin package tuodaan myös tänne ylempänä
 */

public class Elokuva {
    public String name;
    public String imdb;
    public String length;
    public int genre_id;

    /**
     * @author teemuiljin
     * Pitää rakentaa lista nimistä ja genreistä elokuvat.dat ja genret.dat tiedostoihin
     */


    public void tulostaTiedot() {
        System.out.println("Nimi: " + name);
        System.out.println("IMDB: " + imdb);
        System.out.println("Pituus: " + length);
        System.out.println("Genre ID: " + genre_id);
    }

    /**
     * @author teemuiljin
     * Lisään tänne luokan sisälle elokuvien ilmaisumetodit ajallaan
     */


}



