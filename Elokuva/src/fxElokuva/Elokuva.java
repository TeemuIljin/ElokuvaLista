package fxElokuva;

/**
 * @author teemuiljin
 * Genre java luokka, johon laitetaan tietoja genreistä, joka haetaan ELOKUVAT LUOKKAAT
 * TÄRKEÄNÄ GENRE-ID
 */

public class Elokuva {


    private int genre_id;

    private String nimi;

    private String imdb;

    private String pituus;



    private static int seuraavaVapaa = 1;
    private int tunnusNro;

    public Elokuva(){
        rekisteroi();
    }
    public Elokuva(int genre_id, String nimi, String imdb, String pituus){
        rekisteroi();
        this.nimi = nimi;
        this.genre_id = genre_id;
        this.imdb = imdb;
        this.pituus = pituus;
    }

    public void rekisteroi() {
        tunnusNro = seuraavaVapaa;
        seuraavaVapaa++;
    }

    public void tulosta(java.io.PrintStream out) {
        out.println("Elokuva numero: " + tunnusNro +" " + nimi + " " + imdb + " " + pituus);
    }


    public static void main(String args[]) {
        Elokuva hp = new Elokuva(), bm2 = new Elokuva(1, "harri", "moi", "3h30m");
        hp.tulosta(System.out);
        hp.tulosta(System.out);
        bm2.tulosta(System.out);
        bm2.tulosta(System.out);
    }
}




