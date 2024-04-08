package fxElokuva;
import java.io.*;
import java.util.*;


/**
 * @author teemuiljin
 * Elokuvat java luokka sisältää tietoja elokuvista ja pitää kirjaa niiden lukumäärästä käyttäen lkm.
 * (EI TARVITA MAINIA)
 */

public class Elokuvat {


        /**
         * @author teemuiljin
         * alustetaan elokuvalista
         * tehdään lkm jolloin lista dynaamisempi ja ei tarvitse foria
         */
        private List<Elokuva> elokuvat = new ArrayList<Elokuva>();

        //private Elokuva elokuva[] = new Elokuva[20];
        private boolean muutettu = false;
        private int lkm = 0;

        /**
         * @author teemuiljin
         * lisää halutun elokuvan listaan ja kasvattaa lkm yhdellä eli ei päällekkäin.
         */

        public void Muutettu() {
            muutettu = true;
        }
        public int GetLkm () {
            return lkm;
}

        public boolean OnkoMuutettu() {
            return muutettu;
        }
        public void lisaa(Elokuva elokuva){
            elokuvat.add(elokuva);
            Muutettu();
        }

        /**
         * @author teemuiljin
         * Tehdään ja alustetaan elokuvia
         * Lisätään ne myös lisää-metodilla listaan
         * getteri tehty lisäksi jota kutsutaan myöhemmin
         */

        public List<Elokuva> getElokuvat() {
            return elokuvat;
        }

        public Elokuvat(){
        }

        /**
         * @author teemuiljin
         * Lue tiedostosta lukee datan tiedostosta 19.3
         */

        public void lueTiedostosta() throws IOException, SailoException {

            BufferedReader reader = new BufferedReader(new FileReader("Tiedostot/Elokuvat.dat"));
            String line;


            while ((line = reader.readLine()) != null) {
                Elokuva elokuva = Elokuva.parse(line);
                lisaa(elokuva);
            }
            reader.close();
            return;
        }

        public void tallenna() throws SailoException {
            if ( !OnkoMuutettu() ) return;

            File fbak = new File("Tiedostot/Elokuvat.bak");
            File ftied = new File("Tiedostot/Elokuvat.dat");
            fbak.delete(); // if .. System.err.println("Ei voi tuhota");
            ftied.renameTo(fbak); // if .. System.err.println("Ei voi nimetä");

            try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {

                for (Elokuva elokuva : elokuvat) {
                    fo.println(elokuva.toString());
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
     * Poistaa elokuvan 2.4
     */

    public void poista(Elokuva elokuva) {
        elokuvat.remove(elokuva);
        lkm--;
        Muutettu();
    }
}


