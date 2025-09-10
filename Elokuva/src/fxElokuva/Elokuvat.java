package fxElokuva;
import java.io.*;
import java.util.*;


/**
 * @author teemuiljin
 * Elokuvat java luokka sisältää tietoja elokuvista ja pitää kirjaa niiden lukumäärästä käyttäen lkm.
 * (EI TARVITA MAINIA)
 */

public class Elokuvat implements Iterable<Elokuva>{



        /**
         * @author teemuiljin
         * alustetaan elokuvalista
         * tehdään lkm jolloin lista dynaamisempi ja ei tarvitse foria
         */
        //private List<Elokuva> elokuvat = new ArrayList<Elokuva>();

        private Elokuva[] elokuvat = new Elokuva[10];



        /**
         * @author teemuiljin
         * muutettu on alussa false kunnes laitamme sen olemaan true tallennusta varten yms.
         */

        private boolean muutettu = false;
        private int lkm = 0;

        private static final String DATA_DIR = "Tiedostot";
        private static final String DATA_FILE = DATA_DIR + "/Elokuvat.dat";
        private static final String BAK_FILE = DATA_DIR + "/Elokuvat.bak";

        private static void ensureDataDirectoryExists() {
            File dir = new File(DATA_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        }

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
           return lkm;
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
         * manuaalisesti
        */
        public void lisaa(Elokuva elokuva){
            if (lkm >= elokuvat.length) {
                Elokuva[] taulukko = new Elokuva[elokuvat.length+10];
                for (int i = 0; i < elokuvat.length;i++) {
                    taulukko[i] = elokuvat[i];
                }
                elokuvat = taulukko;
            }
            elokuvat[lkm] = elokuva;
            Muutettu();
            lkm++;
        }

        /**
         * @author teemuiljin
         * Lisätään elokuvat myös lisää-metodilla listaan
         * listan getteri alempana
         */

        public Elokuva[] getElokuvat() {
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
            ensureDataDirectoryExists();
            File file = new File(DATA_FILE);
            if (!file.exists()) return;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Elokuva elokuva = Elokuva.parse(line);
                    lisaa(elokuva);
                }
            }
            return;
        }

    /**
     * @author teemuiljin
     * tallentaa dat ja bak tiedostojen avulla eli tekee uudet päällekkäin
     * rakentaa tiedostot uudestaan rivi kerrallaan
     */

        public void tallenna() throws SailoException {
            if ( !OnkoMuutettu() ) return;
            ensureDataDirectoryExists();
            File fbak = new File(BAK_FILE);
            File ftied = new File(DATA_FILE);
            fbak.delete(); // if .. System.err.println("Ei voi tuhota");
            ftied.renameTo(fbak); // if .. System.err.println("Ei voi nimetä");
            try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {
                for (Elokuva elokuva : elokuvat) {
                    if (elokuva != null) {
                        fo.println(elokuva.toString());
                    }
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
     * etsii id:n ja palauttaa sen
     * failsafe tehty siihen
     */

        public int etsiId(Elokuva elokuva) {
            for (int i = 0; i < elokuvat.length; i++){
                if (elokuvat[i] != null && elokuva.getUniikkiID() == elokuvat[i].getUniikkiID()){
                    return elokuva.getUniikkiID();
                }
            }
            return -1;
        }

    /**
     * @author teemuiljin
     * Poistaa elokuvan listasta
     * kutsumalla etsiID
     */
    public void poista(Elokuva elokuva) {
        int poistaID = etsiId(elokuva);
        poista(poistaID);
    }

    /**
     * @author teemuiljin
     * poistaa silmukalla ja muuttaa lkm tarvittaessa
     */
    public void poista(int id) {
        if (id == -1 || id >= elokuvat.length) {
            return;
        }
        for (int i = id; i < elokuvat.length - 1; i++) {
            elokuvat[i] = elokuvat[i+1];
        }
        elokuvat[elokuvat.length - 1] = null; // Clearing the last element
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
        for (Elokuva elokuva : this) {
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

    /**
     * @author teemuiljin
     * iteraattorin konstruktori
     * jotta voimme käyttää
     */

    public Iterator<Elokuva> iterator() {
        return new ElokuvaIterator();
    }

    /**
     * @author teemuiljin
     * Iterator luokka jonka avulla luetaan tiedosto
     */

    public class ElokuvaIterator implements Iterator<Elokuva>{


        /**
         * @author teemuiljin
         * kohdalla seuraa listan kokoa ja kasvaa
         */
        private int kohdalla = 0;

        /**
         * @author teemuiljin
         * kohdalla seurataan kunnes ei ole enää elokuvia
         */
        @Override
        public boolean hasNext() {
            if (kohdalla < GetLkm()) {
                return true;
            }
            return false;
        }

        /**
         * @author teemuiljin
         * elokuvien lukeminen omiin kenttiin
         */
        @Override
        public Elokuva next() {
            if (hasNext()){
                return elokuvat[kohdalla++];
            }
            throw new NoSuchElementException("Ei ole");
        }
    }

}


