package fxElokuva;

import fxElokuva.Elokuva;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Elokuvatest luokka, testata elokuvien ominaisuuksia
 * yksi neljästä testiluokasta ja kaikkea järkevää testataan tässä luokassa
 */
class ElokuvaTest {

    /**
     * @author teemuiljin
     * testaa elokuvan tietoja tulostusmuotoa
     */
    @Test
    void testTietojaElokuva() {
        Elokuva elokuva = new Elokuva("Pulp Fiction", "8.9", "2h 34min", "Draama", "1");
        String expected = " Nimi: Pulp Fiction, imdb: 8.9, Kesto: 2h 34min, genre: Draama, ID: 1";
        assertEquals(expected, elokuva.tietojaElokuva());
    }

    /**
     * @author teemuiljin
     * testaa parsea ja toimivuutta tulostuksessa
     */

    @Test
    void testParse() {
        String data = "Inception|8.8|2h 28min|Toiminta|2";
        Elokuva parsedElokuva = Elokuva.parse(data);
        assertEquals("Inception", parsedElokuva.getNimi());
        assertEquals("8.8", parsedElokuva.getImdb());
        assertEquals("2h 28min", parsedElokuva.getPituus());
        assertEquals("Toiminta", parsedElokuva.getGenre());
        assertEquals(2, parsedElokuva.getUniikkiID());
    }

    /**
     * @author teemuiljin
     * testaa tostringiä ja tulostuksen muotoa
     */

    @Test
    void testToString() {
        Elokuva elokuva = new Elokuva("Avatar", "7.8", "2h 42min", "Sci-Fi", "3");
        assertEquals("Avatar | 7.8 | 2h 42min | Sci-Fi | 3", elokuva.toString());
    }
}
