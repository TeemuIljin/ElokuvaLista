package fxElokuva;

import fxElokuva.Genre;

public class Genret {
    private Genre genre[] = new Genre[10];

    private int lkm = 0;

    private void lisaa(Genre genre) {
        this.genre[lkm] = genre;
        lkm++;
    }

    public Genre[] getGenre() {
        return genre;
    }

    public Genret() {
        Genre hp = new Genre("fantasia", "tutkimusmatka fantasiassa", 1);
        Genre sc4 = new Genre("kauhu", "kauhuelokuvia sumuisille illoille", 2);
        Genre t2 = new Genre("toiminta", "vähintään pg 16 elokuvia", 3);
        Genre jb = new Genre("toiminta", "vähintään pg 16 elokuvia", 3);

        lisaa(hp);
        lisaa(sc4);
        lisaa(t2);
        lisaa(jb);


    }
}