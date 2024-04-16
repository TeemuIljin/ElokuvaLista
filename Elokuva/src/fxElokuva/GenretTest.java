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

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Genrettest luokka, jossa testataan genret tallennusta, toimintaa, tiedostosta lukemista.
 * poistoa ja lisäystä yms.
 * Ei puutu mitään
 */
class GenretTest {

    /**
     * @author teemuiljin
     * alustan genret
     */

    private Genret genret;

    /**
     * @author teemuiljin
     * ennen testejä alustaa genret taulukon
     */
    @BeforeEach
    void setUp() {
        genret = new Genret();
    }

    /**
     * @author teemuiljin
     * testaan lisää-toimintoa ja getlkm toiminnallisuutta
     */
    @Test
    void testLisaaJaGetLkm() {
        Genre genre = new Genre("Draama", "dramis", 1);
        genret.lisaa(genre);
        assertEquals(1, genret.getLkm());
    }

    /**
     * @author teemuiljin
     * testaan onko muutettua ja toimiiko bool oikein
     * se on tärkeä ominaisuus tallennusta varten
     */
    @Test
    void testOnkoMuutettu() {
        assertFalse(genret.OnkoMuutettu());
        genret.Muutettu();
        assertTrue(genret.OnkoMuutettu());
    }

    /**
     * @author teemuiljin
     * testaan lukeeko ohjelma tiedostostosta oikein
     */

    @Test
    void testLueTiedostosta() {
        try {
            genret.lueTiedostosta();
            assertEquals(5, genret.getLkm()); // Olettaen, että tiedostossa on 5 genreä
        } catch (IOException | SailoException e) {
            fail("Poikkeus ei odotettu: " + e.getMessage());
        }
    }

    /**
     * @author teemuiljin
     * testaan myös tallenna ominaisuutta ja sen toimivuutta
     * luon tyhmää dataa ja katson miten se tallennetaan tiedostoon
     */
    @Test
    void testTallenna() {
        // tyhmää dataa
        Genre genre1 = new Genre("pamauksia1", "Toiminta",1);
        Genre genre2 = new Genre("pamauksia2", "Toiminta2",2);
        genret.lisaa(genre1);
        genret.lisaa(genre2);
        try {
            genret.tallenna();
            System.out.println("Tallennetut genret:");
            Files.lines(Paths.get("Tiedostot/Genret.dat")).forEach(System.out::println);
            genret = new Genret();
            genret.lueTiedostosta();
            System.out.println("Ladatut leffat:");
            genret.getGenres().forEach(System.out::println);
            assertEquals(2, genret.getLkm());
        } catch (SailoException | IOException e) {
            fail("poikkeus: " + e.getMessage());
        }
    }
}