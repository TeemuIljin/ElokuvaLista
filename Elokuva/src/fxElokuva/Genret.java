package fxElokuva;

import fxElokuva.Genre;

import java.io.*;
import java.util.Optional;


/**
 * @author teemuiljin
 * Aivan identtinen kuin Elokuvat, mutta genreille
 */

public class Genret {
    private Genre genre[] = new Genre[10];
    private int lkm = 0;
    /**
     * @author teemuiljin
     * muutettu atribuutti tarpeen määritystä varten 19.3
     */
    private boolean muutettu = false;



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
        Genre hp = new Genre("fantasia", "tutkimusmatka");
        Genre sc4 = new Genre("kauhu", "pelkoa");
        Genre t2 = new Genre("toiminta", "paukkumista");

        lisaa(hp);
        lisaa(sc4);
        lisaa(t2);
    }

    /**
     * @author teemuiljin
     * pystytään lukemaan tiedostoa 19.3
     */

    public static Genret lueTiedostosta(String tiedosto) throws IOException, SailoException {
        Genret genret = new Genret();
        BufferedReader reader = new BufferedReader(new FileReader(tiedosto));
        String line;


        String kokonimi = reader.readLine();
        if (kokonimi == null) throw new SailoException("Kokkikirjan nimi puuttuu");
        String rivi = reader.readLine();
        if (rivi == null) throw new SailoException("Maksimikoko puuttuu");


        while ((line = reader.readLine()) != null) {
            Genre genre = Genre.parse(line);
            genret.lisaa(genre);
        }
        reader.close();
        return genret;
    }



    /**
     * @author teemuiljin
     * Tiedoston talletus periaatteessa mahdollista 19.3
     */
    public void talletaTiedostoon(String tiedosto) throws IOException {
        PrintStream out = new PrintStream(tiedosto);
        for (int i = 0; i < lkm; i++) {
            out.println(genre[i].toString());
        }
        out.close();
    }


}
