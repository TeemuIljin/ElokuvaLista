package fxElokuva;

import fxElokuva.Genre;
import fxElokuva.Genret;
import fxElokuva.SailoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class GenretTest {

    private Genret genret;

    @BeforeEach
    void setUp() {
        genret = new Genret();
    }

    @Test
    void testLisaaJaGetLkm() {
        Genre genre = new Genre("Draama", "dramis", 1);
        genret.lisaa(genre);
        assertEquals(1, genret.getLkm());
    }
    @Test
    void testOnkoMuutettu() {
        assertFalse(genret.OnkoMuutettu());
        genret.Muutettu();
        assertTrue(genret.OnkoMuutettu());
    }

    @Test
    void testLueTiedostosta() {
        try {
            genret.lueTiedostosta();
            assertEquals(2, genret.getLkm()); // Olettaen, että tiedostossa on 3 genreä
        } catch (IOException | SailoException e) {
            fail("Poikkeus ei odotettu: " + e.getMessage());
        }
    }

}