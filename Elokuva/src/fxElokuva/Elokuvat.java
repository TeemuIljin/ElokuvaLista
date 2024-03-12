package fxElokuva;
import java.util.*;


/**
 * @author teemuiljin
 * Elokuvat java luokka sisältää tietoja elokuvista ja pitää kirjaa niiden lukumäärästä käyttäen lkm.
 * (EI TARVITA MAINIA)
 */
    import java.io.PrintStream;

    public class Elokuvat {


        /**
         * @author teemuiljin
         * alustetaan elokuvalista
         * tehdään lkm jolloin lista dynaamisempi ja ei tarvitse foria
         */
        private Elokuva elokuva[] = new Elokuva[10];

        private int lkm = 0;

        /**
         * @author teemuiljin
         * lisää halutun elokuvan listaan ja kasvattaa lkm yhdellä eli ei päällekkäin.
         */

        public void lisaa(Elokuva elokuva){
            this.elokuva[lkm] = elokuva;
            lkm++;
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
            Elokuva hp = new Elokuva(1, "Harry potter 1", "8.2", "3h30m");
            Elokuva sc4 = new Elokuva(2, "Scream 4","8.8", "2h50m");
            Elokuva t2 = new Elokuva(3, "Terminator 2","7.1", "2h30m");
            Elokuva jb = new Elokuva(4, "James Bond","9.3", "3h15m");

            lisaa(hp);
            lisaa(sc4);
            lisaa(t2);
            lisaa(jb);
            System.out.println();


            /**
             * @author teemuiljin
             * Lopuksi vielä nopea testi
             * (turha testi, mutta pidän sen nyt toistaiseksi)
             */
            //System.out.println("Kaikki elokuvat:");
            //for (int i = 0; i < this.lkm; i++) {
            //System.out.println("Elokuva " + (i+1) + ": " + this.elokuva[i].tietojaElokuva());

        }


        }


