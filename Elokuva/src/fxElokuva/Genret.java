package fxElokuva;

import fxElokuva.Genre;

import java.io.*;
import java.util.Optional;


/**
 * @author teemuiljin
 * Aivan identtinen kuin Elokuvat, mutta genreille
 */

public class Genret {
    private Genre genre[] = new Genre[20];
    private int lkm = 0;

    public boolean OnkoMuutettu() {
        return muutettu;
    }

    public void Muutettu() {
        muutettu = true;
    }

    /**
     * @author teemuiljin
     * muutettu atribuutti tarpeen määritystä varten 19.3
     */
    private boolean muutettu = false;



    public void lisaa(Genre genre) {
        this.genre[lkm] = genre;
        lkm++;
        Muutettu();
    }
    public int getLkm() {
        return lkm;
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
     * Konstruktori
     */

    public Genret() {
    }

    /**
     * @author teemuiljin
     * pystytään tallentamaan tiedosto 31.3 /tallenna)
     */

    public void tallenna() throws SailoException {
        if ( !OnkoMuutettu() ) return;

        File fbak = new File("Tiedostot/Genret.bak");
        File ftied = new File("Tiedostot/Genret.dat");
        fbak.delete(); // if .. System.err.println("Ei voi tuhota");
        ftied.renameTo(fbak); // if .. System.err.println("Ei voi nimetä");

        try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {

            for (int i = 0; i<lkm ; i++) {
                fo.println(genre[i].toString());
            }
            //} catch ( IOException e ) { // ei heitä poikkeusta
            //  throw new SailoException("Tallettamisessa ongelmia: " + e.getMessage());
        } catch ( FileNotFoundException ex ) {
            throw new SailoException("Tiedosto " + ftied.getName() + " ei aukea");
        } catch ( IOException ex ) {
            throw new SailoException("Tiedoston " + ftied.getName() + " kirjoittamisessa ongelmia");
        }

        Muutettu();
    }


    /**
     * @author teemuiljin
     * Luetiedostosta 31.3
     */

    public void lueTiedostosta() throws IOException, SailoException {

        BufferedReader reader = new BufferedReader(new FileReader("Tiedostot/Genret.dat"));
        String line;


        while ((line = reader.readLine()) != null) {
            Genre genre = Genre.parse(line);
            lisaa(genre);
        }
        reader.close();
        return;
    }



}
