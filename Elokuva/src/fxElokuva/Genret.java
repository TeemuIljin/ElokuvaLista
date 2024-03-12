package fxElokuva;

import fxElokuva.Genre;

import java.util.Optional;


/**
 * @author teemuiljin
 * Aivan identtinen kuin Elokuvat, mutta genreille
 */

public class Genret {
    private Genre genre[] = new Genre[10];

    private int lkm = 0;

    public void lisaa(Genre genre) {
        this.genre[lkm] = genre;
        lkm++;
    }
    /**
     * @author teemuiljin
     * Peursgetteri, jota kutsutaan myöhemmin
     */

    public Genre[] getGenre() {
        return genre;
    }

    /**
     * @author teemuiljin
     * luodaan pari yksinkertaista elokuvaa ja asetetaan niille tiedot
     */

    public Genret() {
        Genre hp = new Genre("fantasia", "tutkimusmatka fantasiassa");
        Genre sc4 = new Genre("kauhu", "kauhuelokuvia sumuisille illoille");
        Genre t2 = new Genre("toiminta", "vähintään pg 16 elokuvia");

        lisaa(hp);
        lisaa(sc4);
        lisaa(t2);


    }


}
