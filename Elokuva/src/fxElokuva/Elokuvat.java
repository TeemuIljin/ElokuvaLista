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

        /**
         * @author teemuiljin
         * muutettu on alussa false kunnes laitamme sen olemaan true tallennusta varten yms.
         */
        private boolean muutettu = false;
        private int lkm = 0;

        /**
         * @author teemuiljin
         * lisää halutun elokuvan listaan ja kasvattaa lkm yhdellä eli ei päällekkäin.
         */

        /**
         * @author teemuiljin
         * tarkkailee muutettu statusta
         */

        public void Muutettu() {
            muutettu = true;
        }

         /**
          * @author teemuiljin
          * getlkm tekee uniikin lkm jota tarkkaillaan
          */
        public int GetLkm () {
           return elokuvat.size();
        }

        /**
        * @author teemuiljin
        * katsoo onko muutettu
        */

        public boolean OnkoMuutettu() {
            return muutettu;
        }

        /**
         * @author teemuiljin
        * lisää elokuvan listaan ja tekee muutoksen muutettu statukseen
        */
        public void lisaa(Elokuva elokuva){
            elokuvat.add(elokuva);
            Muutettu();
            lkm++;
        }

        /**
         * @author teemuiljin
         * Lisätään elokuvat myös lisää-metodilla listaan
         * listan getteri alempana
         */

        public List<Elokuva> getElokuvat() {
            return elokuvat;
        }

        /**
        * @author teemuiljin
        * uusi konstruktori
        */

        public Elokuvat(){
        }

        /**
         * @author teemuiljin
         * Lue tiedostosta lukee datan tiedostosta
         * lukee tiedoston rivi kerrallan
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

    /**
     * @author teemuiljin
     * tallentaa dat ja bak tiedostojen avulla eli tekee uudet päällekkäin
     * rakentaa tiedostot uudestaan rivi kerrallaan
     */

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
            } catch ( FileNotFoundException ex ) {
                throw new SailoException("Tiedosto " + ftied.getName() + " ei aukea");
            } catch ( IOException ex ) {
                throw new SailoException("Tiedoston " + ftied.getName() + " kirjoittamisessa ongelmia");
            }
            Muutettu();
        }

    /**
     * @author teemuiljin
     * Poistaa elokuvan listasta ja pienentää lkm sekä kutsuu muutettua
     */
    public void poista(Elokuva elokuva) {
        elokuvat.remove(elokuva);
        lkm--;
        Muutettu();
    }

    /**
     * @author teemuiljin
     * Laskee kaikkien elokuvien imdb keskiarvon ja toimii dynaamisesti
     * palauttaa keskiarvon textfieldiin
     */

    public String LaskeImdb() {
        double summa = 0;
        double keskiarvo = 0;
        String returnvalue;
        for (Elokuva elokuva : elokuvat) {
            String imdb = elokuva.getImdb();
            double imdb_double = Double.parseDouble(imdb);
            summa += imdb_double;
        }
        if (GetLkm() > 0) {
            keskiarvo = summa / GetLkm();
        }
        returnvalue = String.format("%.1f", keskiarvo);
        return returnvalue;
    }
}


