package fxElokuva;

/**
 * @author teemuiljin
 * Genre java luokka, johon laitetaan tietoja genreistä, joka haetaan mainiin
 * TÄRKEÄNÄ GENRE-ID
 */

public class Elokuva {
    private String nimi;
    private String ohjaaja;
    private int julkaisuvuosi;
    private int genreId;

    // Konstruktori
    public Elokuva(String nimi, String ohjaaja, int julkaisuvuosi, int genreId) {
        this.nimi = nimi;
        this.ohjaaja = ohjaaja;
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

    public String getOhjaaja() {
        return ohjaaja;
    }

    public void setOhjaaja(String ohjaaja) {
        this.ohjaaja = ohjaaja;
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

