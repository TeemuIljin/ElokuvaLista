package fxElokuva;

import fxElokuva.Genre;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Genretest luokka, jossa testataan genrejen toimintaa, parsea ja tulostusta yms.
 * ei puutu mitään
 */
class GenreTest {

    /**
     * @author teemuiljin
     * testaan tietojagenreä ja sen tulostuksen oikeellisuutta
     */

    @Test
    void testTietojaGenre() {
        Genre genre = new Genre("Draama", "Tämä on draaman kuvaus",1);
        String expected = " Tiedot: Tämä on draaman kuvaus, Genre: Draama, Genren ID: 1";
        assertEquals(expected, genre.tietojaGenre());
    }

    /**
     * @author teemuiljin
     * testaan parsea ja tulostuksen toimintaa
     * odotan arvoa ja saan odotetun arvon
     */
    @Test
    void testParse() {
        String data = "Toiminta|Toimintaelokuvien kuvaus|2";
        Genre parsedGenre = Genre.parse(data);
        assertEquals("Toimintaelokuvien kuvaus", parsedGenre.getGenrekuvaus());
        assertEquals("Toiminta", parsedGenre.getGenrenimi());
        assertEquals(2, parsedGenre.getUniikkiID());
    }

    /**
     * @author teemuiljin
     * Testaan tostringin toimivuutta ja varmistan, että se toimii halutulla tavalla
     * kaikki eroteltuina omissa lokeroissa
     */
    @Test
    void testToString() {
        Genre genre = new Genre("Komedia", "Tämä on komedian kuvaus", 3);
        assertEquals("Tämä on komedian kuvaus|Komedia|3", genre.toString());
    }
}
