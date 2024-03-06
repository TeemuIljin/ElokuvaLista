package fxElokuva;

/**
 * @author teemuiljin
 * Genre java luokka, johon laitetaan tietoja genreistä, joka haetaan ELOKUVAT LUOKKAAT
 * TÄRKEÄNÄ GENRE-ID
 */

public class Elokuva {
    private String nimi;
    private String pituus;
    private int julkaisuvuosi;
    private int genreId;

    // Konstruktori
    public Elokuva(String nimi, String pituus, int julkaisuvuosi, int genreId) {
        this.nimi = nimi;
        this.pituus = pituus;
        this.julkaisuvuosi = julkaisuvuosi;
        this.genreId = genreId;
    }

    // Getterit ja setterit
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getPituus() {
        return pituus;
    }

    public void setPituus(String ohjaaja) {
        this.pituus = ohjaaja;
    }

    public int getJulkaisuvuosi() {
        return julkaisuvuosi;
    }

    public void setJulkaisuvuosi(int julkaisuvuosi) {
        this.julkaisuvuosi = julkaisuvuosi;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}

