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
        private Elokuva elokuva[] = new Elokuva[10];
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
            this.elokuva[lkm] = elokuva;
            lkm++;
            Muutettu();
        }

        /**
         * @author teemuiljin
         * Tehdään ja alustetaan elokuvia
         * Lisätään ne myös lisää-metodilla listaan
         * getteri tehty lisäksi jota kutsutaan myöhemmin
         */

        public Elokuva[] getElokuvat() {
            return elokuva;
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

                for (int i = 0; i<lkm ; i++) {
                    fo.println(elokuva[i].toString());
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
         * Tallentaa tieodstoon 19.3
         */

        /**
         * @author teemuiljin
         * Attribuutti pitää kirjaa tiedon säilyttämisen tarpeesta 19.3
         */


    }


