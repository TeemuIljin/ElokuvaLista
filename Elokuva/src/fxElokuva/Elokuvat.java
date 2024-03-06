package fxElokuva;
import java.util.*;



/**
 * @author teemuiljin
 * Elokuvat java luokka, johon haetaan elokuva luokasta tietoja ja vie eteenpäin mainiin
 * TÄRKEÄNÄ GENRE-ID
 */
    import java.io.PrintStream;

    public class Elokuvat {


        private Elokuva elokuva[] = new Elokuva[10];

        private int lkm = 0;

        private void lisaa(Elokuva elokuva){
                this.elokuva[lkm] = elokuva;
                lkm++;
        }
        




        public static void main(String args[]) {
            Elokuva hp = new Elokuva(1, "harri", "moi", "3h30m");
            Elokuvat elokuvat = new Elokuvat();
            elokuvat.lisaa(hp);
            System.out.println();

        }
    }


