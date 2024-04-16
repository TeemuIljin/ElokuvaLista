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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author teemuiljin
 * Elokuvat test testaa elokuvan tulostusta, tallennusta ja poistoa
 * kaikki järjkevä testataan ja mitään ei puutu
 */

class ElokuvatTest {

    /**
     * @author teemuiljin
     * alustaa elokuvat
     */

    private Elokuvat elokuvat;

    /**
     * @author teemuiljin
     * tekee ennen joka testiä elokuvat taulukon
     */

    @BeforeEach
    void setUp() {
        elokuvat = new Elokuvat();
    }

    /**
     * @author teemuiljin
     * testaa lisää ja get lkm toimivuuden
     */

    @Test
    void testLisaaJaGetLkm() {
        Elokuva elokuva = new Elokuva("Elokuva 1", "7.7", "2h 30m", "toiminta", "1");
        elokuvat.lisaa(elokuva);
        assertEquals(1, elokuvat.GetLkm());
    }

    /**
     * @author teemuiljin
     * testaa onko listaa muutettu uusilla elokuvilla tai poistolla
     */

    @Test
    void testOnkoMuutettu() {
        assertFalse(elokuvat.OnkoMuutettu());
        elokuvat.Muutettu();
        assertTrue(elokuvat.OnkoMuutettu());
    }

    /**
     * @author teemuiljin
     * testaa poistaa elokuvan ja lisää elokuvan
     */
    @Test
    void testPoista() {
        Elokuva elokuva1 = new Elokuva("Elokuva 1", "7.7", "2h 30m", "draama", "1");
        Elokuva elokuva2 = new Elokuva("Elokuva 2", "7.8", "2h 35m", "Toiminta", "2");
        elokuvat.lisaa(elokuva1);
        elokuvat.lisaa(elokuva2);

        elokuvat.poista(elokuva1);
        assertEquals(1, elokuvat.GetLkm());
        assertFalse(elokuvat.getElokuvat().contains(elokuva1));
    }

    /**
     * @author teemuiljin
     * testaa tallennaelokuvan tiedostoon ja tallentaa sen oikeaan tiedostoon
     * tehdään dummy elokuvat ja katsotaan toimiiko tulostus ja dat/bak filet
     */
    @Test
    void testTallenna() {
        Elokuva elokuva1 = new Elokuva("Elokuva 1", "7.7", "2h 30m", "toiminta", "1");
        Elokuva elokuva2 = new Elokuva("Elokuva 2", "7.8", "2h 35m", "Draama", "2");
        elokuvat.lisaa(elokuva1);
        elokuvat.lisaa(elokuva2);
        try {
            // kutsu tallenna metodia
            elokuvat.tallenna();
            System.out.println("Tallennetut elokuvat:");
            Files.lines(Paths.get("Tiedostot/Elokuvat.dat")).forEach(System.out::println);
            elokuvat = new Elokuvat();
            elokuvat.lueTiedostosta();
            System.out.println("Ladatut leffat:");
            elokuvat.getElokuvat().forEach(System.out::println);
            assertEquals(2, elokuvat.GetLkm());
        } catch (SailoException | IOException e) {
            fail("poikkeus: " + e.getMessage());
        }
    }

    /**
     * @author teemuiljin
     * testaan laskeimdb usealla elokuvalla ja varmistan toimivuuden
     */
    @Test
    public void testLaskeImdbUseallaElokuvalla() {
        List<Elokuva> testiElokuvat = new ArrayList<>();
        testiElokuvat.add(new Elokuva("Elokuva1", "8.0", "2h 30m", "toiminta", "1"));
        testiElokuvat.add(new Elokuva("Elokuva2", "7.5", "2h 10m", "draama", "2"));
        testiElokuvat.add(new Elokuva("Elokuva3", "6.5", "1h 50m", "komedia", "3"));
        for (Elokuva elokuva : testiElokuvat) {
            elokuvat.lisaa(elokuva);
        }
        assertEquals("7,3", elokuvat.LaskeImdb());
    }
}

