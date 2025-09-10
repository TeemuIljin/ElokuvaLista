package fxElokuva;

/**
 * Validaatio-työkaluja sovelluksen käyttöön.
 * 
 * <p>Tämä luokka sisältää yleisiä validaatiometodeja, joita käytetään
 * käyttäjän syötteiden tarkistamiseen ennen tallentamista.</p>
 * 
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * @version 2.0
 * @since 1.0
 */
public final class ValidationUtils {
    
    // Private constructor to prevent instantiation
    private ValidationUtils() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    /**
     * Tarkistaa onko merkkijono tyhjä tai null.
     * 
     * @param input tarkistettava merkkijono
     * @return true jos merkkijono on tyhjä tai null
     */
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
    
    /**
     * Tarkistaa onko IMDB-arvo kelvollinen.
     * 
     * @param imdb tarkistettava IMDB-arvo
     * @return true jos IMDB-arvo on kelvollinen (0.0-10.0)
     */
    public static boolean isValidImdbRating(String imdb) {
        if (isEmpty(imdb)) {
            return false;
        }
        
        try {
            double rating = Double.parseDouble(imdb);
            return rating >= 0.0 && rating <= 10.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Tarkistaa onko ID-numero kelvollinen.
     * 
     * @param id tarkistettava ID
     * @return true jos ID on kelvollinen positiivinen kokonaisluku
     */
    public static boolean isValidId(String id) {
        if (isEmpty(id)) {
            return false;
        }
        
        try {
            int idValue = Integer.parseInt(id);
            return idValue > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Tarkistaa onko elokuvan tiedot kelvolliset.
     * 
     * @param nimi elokuvan nimi
     * @param imdb IMDB-arvo
     * @param pituus elokuvan pituus
     * @return true jos kaikki tiedot ovat kelvolliset
     */
    public static boolean isValidMovieData(String nimi, String imdb, String pituus) {
        return !isEmpty(nimi) && isValidImdbRating(imdb) && !isEmpty(pituus);
    }
    
    /**
     * Tarkistaa onko genren tiedot kelvolliset.
     * 
     * @param nimi genren nimi
     * @param kuvaus genren kuvaus
     * @return true jos molemmat tiedot ovat kelvolliset
     */
    public static boolean isValidGenreData(String nimi, String kuvaus) {
        return !isEmpty(nimi) && !isEmpty(kuvaus);
    }
    
    /**
     * Siivoaa merkkijonon poistamalla ylimääräiset välilyönnit.
     * 
     * @param input siivottava merkkijono
     * @return siivottu merkkijono tai tyhjä merkkijono jos input on null
     */
    public static String cleanString(String input) {
        return input == null ? "" : input.trim();
    }
}
