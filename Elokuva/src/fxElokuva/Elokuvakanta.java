package fxElokuva;
import java.io.IOException;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Elokuvakanta luokka, jonka avulla siirrytään luokasta toiseen
 * getterien avulla
 * (EI TARVITSE MAINIA)
 */
public class Elokuvakanta {

    /**
     * @author teemuiljin
     * Alustukset listalle elokuvat
     */
    private Elokuvat elokuvalista = new Elokuvat();

    /**
     * @author teemuiljin
     * Alustukset genreille
     */

    private Genret genret = new Genret();

    /**
     * @author teemuiljin
     * Getteri kaikelle elokuvat
     */
    public Elokuvat getElokuvalista() {
        return elokuvalista;

    }
    /**
     * @author teemuiljin
     * Getteri kaikelle genret
     */

    public Genret getGenret() {
        return genret;
    }

    /**
     * @author teemuiljin
     * TalletaElokuvat menee guihin kannan kautta
     */
    public void talletaElokuvat() throws SailoException {
       elokuvalista.tallenna();
    }

    /**
     * @author teemuiljin
     * TalletaGenret menee guihin kannan kautta
     */

    public void talletaGenret() throws SailoException {
        genret.tallenna();
    }


    /**
     * @author teemuiljin
     * Lukee elokuvat alempaata luetiedostosta avulla
     */


    public void LueElokuvat() throws SailoException, IOException {
        elokuvalista.lueTiedostosta();
    }
    /**
     * @author teemuiljin
     * Lukee genret alemmasta luetiedoston avulla
     */

    public void LueGenret() throws SailoException, IOException {
        genret.lueTiedostosta();
    }

    /**
     * @author teemuiljin
     * Konstruktori elokuvakannalle
     */

    Elokuvakanta() {}
}
