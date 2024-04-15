package fxElokuva;

import fxElokuva.Genre;
import fxElokuva.Genret;
import fxElokuva.SailoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            assertEquals(5, genret.getLkm()); // Olettaen, että tiedostossa on 5 genreä
        } catch (IOException | SailoException e) {
            fail("Poikkeus ei odotettu: " + e.getMessage());
        }
    }
    @Test
    void testTallenna() {
        // tyhmää dataa
        Genre genre1 = new Genre("pamauksia1", "Toiminta",1);
        Genre genre2 = new Genre("pamauksia2", "Toiminta2",2);
        genret.lisaa(genre1);
        genret.lisaa(genre2);

        try {
            // kutsu tallenna metodia
            genret.tallenna();

            System.out.println("Tallennetut genret:");
            Files.lines(Paths.get("Tiedostot/Genret.dat")).forEach(System.out::println);

            // Alusta elokuvat lukemaan tiedostosta
            genret = new Genret();
            // Load elokuvat from file
            genret.lueTiedostosta();

            //tulostus
            System.out.println("Ladatut leffat:");
            genret.getGenres().forEach(System.out::println);

            // tarkista samanlaisuus
            assertEquals(2, genret.getLkm());
        } catch (SailoException | IOException e) {
            fail("poikkeus: " + e.getMessage());
        }
    }

}