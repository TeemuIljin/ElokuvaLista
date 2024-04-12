package fxElokuva;

//alertit yms

//lista

import java.io.IOException;

//ohjelmat


public class Elokuvakanta {

    /**
     * @author teemuiljin
     * Alustukset listoille
     */
    private Elokuvat elokuvalista = new Elokuvat();
    private Genret genret = new Genret();

    /**
     * @author teemuiljin
     * Getterit kaikelle
     */
    public Elokuvat getElokuvalista() {
        return elokuvalista;

    }
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
     * Lukee elokuvat alempaata
     */


    public void LueElokuvat() throws SailoException, IOException {
        elokuvalista.lueTiedostosta();
    }
    /**
     * @author teemuiljin
     * Lukee genret alempaata
     */

    public void LueGenret() throws SailoException, IOException {
        genret.lueTiedostosta();
    }

    /**
     * @author teemuiljin
     * Konstruktori
     */

    Elokuvakanta() {

    }
}
