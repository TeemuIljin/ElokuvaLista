package fxElokuva;

import fxElokuva.Genre;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenreTest {

    @Test
    void testTietojaGenre() {
        Genre genre = new Genre("Draama", "Tämä on draaman kuvaus",1);
        String expected = " Tiedot: Tämä on draaman kuvaus, Genre: Draama, Genren ID: 1";
        assertEquals(expected, genre.tietojaGenre());
    }
    @Test
    void testParse() {
        String data = "Toiminta|Toimintaelokuvien kuvaus|2";
        Genre parsedGenre = Genre.parse(data);
        assertEquals("Toimintaelokuvien kuvaus", parsedGenre.getGenrekuvaus());
        assertEquals("Toiminta", parsedGenre.getGenrenimi());
        assertEquals(2, parsedGenre.getUniikkiID());
    }

    @Test
    void testToString() {
        Genre genre = new Genre("Komedia", "Tämä on komedian kuvaus", 3);
        assertEquals("Tämä on komedian kuvaus|Komedia|3", genre.toString());
    }
}
