package fxElokuva;

//alertit yms

//lista

import java.io.IOException;

//ohjelmat


public class Elokuvakanta {

    private Elokuvat elokuvalista = new Elokuvat();
    private Genret genret = new Genret();

    public Elokuvat getElokuvalista() {
        return elokuvalista;

    }
    public Genret getGenret() {
        return genret;
    }

    /**
     * @author teemuiljin
     * TalletaElokuvat menee guihin kannan kautta tein try/catchin 19.3
     */
    public void talletaElokuvat() throws SailoException {
       elokuvalista.tallenna();
    }

    public void LueElokuvat() throws SailoException, IOException {
        elokuvalista.lueTiedostosta();
    }

}
