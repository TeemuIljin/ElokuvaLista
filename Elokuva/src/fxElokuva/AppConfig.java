package fxElokuva;

/**
 * Sovelluksen konfiguraatio ja vakiot.
 * 
 * <p>Tämä luokka sisältää sovelluksen käyttämät vakiot ja konfiguraatio-arvot.
 * Vakioiden käyttö helpottaa koodin ylläpitoa ja vähentää "magic number" -ongelmia.</p>
 * 
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * @version 2.0
 * @since 1.0
 */
public final class AppConfig {
    
    // Private constructor to prevent instantiation
    private AppConfig() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    // File paths
    public static final String DATA_DIRECTORY = "Tiedostot";
    public static final String MOVIES_FILE = DATA_DIRECTORY + "/Elokuvat.dat";
    public static final String GENRES_FILE = DATA_DIRECTORY + "/Genret.dat";
    public static final String MOVIES_BACKUP = DATA_DIRECTORY + "/Elokuvat.bak";
    public static final String GENRES_BACKUP = DATA_DIRECTORY + "/Genret.bak";
    
    // Default values
    public static final String DEFAULT_MOVIE_NAME = "Unknown Movie";
    public static final String DEFAULT_IMDB_RATING = "0.0";
    public static final String DEFAULT_DURATION = "0min";
    public static final String DEFAULT_GENRE = "Unknown";
    public static final String DEFAULT_GENRE_NAME = "Unknown Genre";
    public static final String DEFAULT_GENRE_DESCRIPTION = "No description available";
    
    // Array sizes
    public static final int INITIAL_MOVIE_ARRAY_SIZE = 10;
    public static final int ARRAY_GROWTH_SIZE = 10;
    
    // UI Constants
    public static final String APP_TITLE = "Elokuva";
    public static final String ADD_MOVIE_TITLE = "Lisää elokuva";
    public static final String ADD_GENRE_TITLE = "Lisää genre";
    
    // Error messages
    public static final String ERROR_INVALID_DATA = "Virheelliset tiedot";
    public static final String ERROR_MOVIE_INPUT = "Syötä oikeanlaiset tiedot ennen elokuvan lisäämistä.";
    public static final String ERROR_GENRE_INPUT = "Syötä oikeanlaiset tiedot ennen genren lisäämistä.";
    public static final String ERROR_FILE_SAVE = "Tiedoston tallentamisessa ongelmia";
    public static final String ERROR_FILE_READ = "Tiedoston lukemisessa ongelmia";
    
    // Success messages
    public static final String SUCCESS_MOVIE_ADDED = "Elokuva lisätty onnistuneesti";
    public static final String SUCCESS_GENRE_ADDED = "Genre lisätty onnistuneesti";
    public static final String SUCCESS_DATA_SAVED = "Tiedot tallennettu onnistuneesti";
}
