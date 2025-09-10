package fxElokuva;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Yksinkertainen lokitus-työkalu sovelluksen käyttöön.
 * 
 * <p>Tämä luokka tarjoaa peruslokitus-toiminnot ilman ulkoisia riippuvuuksia.
 * Lokit tallennetaan konsoliin ja sisältävät aikaleiman ja viestin.</p>
 * 
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * @version 2.0
 * @since 1.0
 */
public final class Logger {
    
    // Private constructor to prevent instantiation
    private Logger() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    private static final DateTimeFormatter TIMESTAMP_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Lokitustasot
     */
    public enum Level {
        DEBUG, INFO, WARN, ERROR
    }
    
    /**
     * Kirjaa debug-viestin.
     * 
     * @param message viesti
     */
    public static void debug(String message) {
        log(Level.DEBUG, message);
    }
    
    /**
     * Kirjaa info-viestin.
     * 
     * @param message viesti
     */
    public static void info(String message) {
        log(Level.INFO, message);
    }
    
    /**
     * Kirjaa varoitus-viestin.
     * 
     * @param message viesti
     */
    public static void warn(String message) {
        log(Level.WARN, message);
    }
    
    /**
     * Kirjaa virhe-viestin.
     * 
     * @param message viesti
     */
    public static void error(String message) {
        log(Level.ERROR, message);
    }
    
    /**
     * Kirjaa virhe-viestin poikkeuksen kanssa.
     * 
     * @param message viesti
     * @param throwable poikkeus
     */
    public static void error(String message, Throwable throwable) {
        log(Level.ERROR, message + " - " + throwable.getMessage());
        throwable.printStackTrace();
    }
    
    /**
     * Yleinen lokitusmetodi.
     * 
     * @param level lokitustaso
     * @param message viesti
     */
    private static void log(Level level, String message) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        System.out.printf("[%s] %s: %s%n", timestamp, level, message);
    }
}
