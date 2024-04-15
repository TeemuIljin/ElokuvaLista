package fxElokuva;
import fxElokuva.Elokuva;
import fxElokuva.Elokuvat;
import fxElokuva.SailoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElokuvatTest {

    private Elokuvat elokuvat;

    @BeforeEach
    void setUp() {
        elokuvat = new Elokuvat();
    }

    @Test
    void testLisaaJaGetLkm() {
        Elokuva elokuva = new Elokuva("Elokuva 1", "7.7", "2h 30m", "toiminta", "1");
        elokuvat.lisaa(elokuva);
        assertEquals(0, elokuvat.GetLkm());
    }

    @Test
    void testOnkoMuutettu() {
        assertFalse(elokuvat.OnkoMuutettu());
        elokuvat.Muutettu();
        assertTrue(elokuvat.OnkoMuutettu());
    }

    @Test
    void testPoista() {
        Elokuva elokuva1 = new Elokuva("Elokuva 1", "7.7", "2h 30m", "Draama", "1");
        Elokuva elokuva2 = new Elokuva("Elokuva 2", "7.8", "2h 35m", "Toiminta", "2");
        elokuvat.lisaa(elokuva1);
        elokuvat.lisaa(elokuva2);

        elokuvat.poista(elokuva1);
        assertEquals(-1, elokuvat.GetLkm());
        assertFalse(elokuvat.getElokuvat().contains(elokuva1));
    }
    @Test
    void testTallenna() {
        // tyhmää dataa
        Elokuva elokuva1 = new Elokuva("Elokuva 1", "7.7", "2h 30m", "toiminta", "1");
        Elokuva elokuva2 = new Elokuva("Elokuva 2", "7.8", "2h 35m", "Draama", "2");
        elokuvat.lisaa(elokuva1);
        elokuvat.lisaa(elokuva2);

        try {
            // kutsu tallenna metodia
            elokuvat.tallenna();

            System.out.println("Tallennetut elokuvat:");
            Files.lines(Paths.get("Tiedostot/Elokuvat.dat")).forEach(System.out::println);

            // Alusta elokuvat lukemaan tiedostosta
            elokuvat = new Elokuvat();
            // Load elokuvat from file
            elokuvat.lueTiedostosta();

            //tulostus
            System.out.println("Ladatut leffat:");
            elokuvat.getElokuvat().forEach(System.out::println);

            // tarkista samanlaisuus
            assertEquals(0, elokuvat.GetLkm());
        } catch (SailoException | IOException e) {
            fail("poikkeus: " + e.getMessage());
        }
    }

}

