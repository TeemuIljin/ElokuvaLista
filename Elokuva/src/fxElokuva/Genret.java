package fxElokuva;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Genret luokka, jossa genrejä luetaan, poistetaan, lisätään ja tallennettaan lista
 * toimii halutulla tavalla
 */

public class Genret {
    /**
     * @author teemuiljin
     * alustan listan
     */
    private List<Genre> genres = new ArrayList<>();

    /**
     * @author teemuiljin
     * katsoo onko muutettu
     */

    public boolean OnkoMuutettu() {
        return muutettu;
    }

    /**
     * @author teemuiljin
     * muutetusta tulee true
     */

    public void Muutettu() {
        muutettu = true;
    }

    /**
     * @author teemuiljin
     * muutettu atribuutti tarpeen määritystä varten 19.3
     */
    private boolean muutettu = false;

    /**
     * @author teemuiljin
     * lisää genren ja muuttaa muutetun
     */

    public void lisaa(Genre genre) {
        genres.add(genre);
        Muutettu();
    }
    /**
     * @author teemuiljin
     * ottaa lukumäärän
     */

    public int getLkm() {
        return genres.size();
    }
    /**
     * @author teemuiljin
     * Peursgetteri, jota kutsutaan myöhemmin
     */

    public List<Genre> getGenres() {
        return genres;
    }
    /**
     * @author teemuiljin
     * Konstruktori
     */

    public Genret() {
    }

    public String Getgenrenamebyid(int id) {
        for (Genre genre : genres) {
            if (genre.getUniikkiID() == id){
                return genre.getGenrekuvaus();
            }
        }
        return "not found";
    }

    /**
     * @author teemuiljin
     * pystytään tallentamaan tiedosto käyttäen dat ja bak filejä
     * luodaan rivi riviltä ja lisätään tiedostoon
     */

    public void tallenna() throws SailoException {
        if ( !OnkoMuutettu() ) return;
        File dataDir = new File("Tiedostot");
        if (!dataDir.exists()) dataDir.mkdirs();

        File fbak = new File("Tiedostot/Genret.bak");
        File ftied = new File("Tiedostot/Genret.dat");
        fbak.delete(); // if .. System.err.println("Ei voi tuhota");
        ftied.renameTo(fbak); // if .. System.err.println("Ei voi nimetä");

        try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {
            for (Genre genre : genres) {
                fo.println(genre.toString());
            }
        } catch ( FileNotFoundException ex ) {
            throw new SailoException("Tiedosto " + ftied.getName() + " ei aukea");
        } catch ( IOException ex ) {
            throw new SailoException("Tiedoston " + ftied.getName() + " kirjoittamisessa ongelmia");
        }

        muutettu = false;
    }


    /**
     * @author teemuiljin
     * Luetiedostosta lukee tiedoston rivi riviltä
     * sen jälkeen sulkee lukijan
     */

    public void lueTiedostosta() throws IOException, SailoException {
        File file = new File("Tiedostot/Genret.dat");
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Genre genre = Genre.parse(line);
                lisaa(genre);
            }
        }
        return;
    }

    /**
     * @author teemuiljin
     * poistaa listasta genren ja muuttaa muutettu statuksen
     */

    public void poista(Genre genre) {
        genres.remove(genre);
        Muutettu();
    }

}
