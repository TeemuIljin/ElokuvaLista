package fxElokuva;
import java.util.*;


/**
 * @author teemuiljin
 * Elokuvat java luokka, johon haetaan elokuva luokasta tietoja ja vie eteenpäin mainiin
 * TÄRKEÄNÄ GENRE-ID
 */
    import java.io.PrintStream;

    public class Elokuvat {


        /**
         * @author teemuiljin
         * alustetaan elokuvalista
         * tehdään lkm jolloin lista dynaamisempi
         */
        private Elokuva elokuva[] = new Elokuva[10];

        private int lkm = 0;

        /**
         * @author teemuiljin
         * lisää halutun elokuvan listaan
         */

        private void lisaa(Elokuva elokuva){
            this.elokuva[lkm] = elokuva;
            lkm++;
        }

        public Elokuva[] getElokuvat() {
            return elokuva;
        }

        public Elokuvat(){
            Elokuva hp = new Elokuva(1, "harri", "moi", "3h30m");
            Elokuva hp2 = new Elokuva(2, "potter", "hei", "3h20m");
            lisaa(hp);
            lisaa(hp2);
            System.out.println();

            System.out.println("Kaikki elokuvat:");
            for (int i = 0; i < this.lkm; i++) {
                System.out.println("Elokuva " + (i+1) + ": " + this.elokuva[i].tietoja());

        }



        /**
         * @author teemuiljin
         * luomme listan tietoja ja voimme jopa tulostaa luodun listan
         */


        }
    }


