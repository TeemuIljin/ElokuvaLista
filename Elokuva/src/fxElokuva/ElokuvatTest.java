package fxElokuva;
import fxElokuva.Elokuva;
import fxElokuva.Elokuvat;
import fxElokuva.SailoException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author teemuiljin
 * Elokuvat test testaa elokuvan tulostusta, tallennusta ja poistoa
 * kaikki järjkevä testataan ja mitään ei puutu
 */

public class ElokuvatTest {
    
    private static int testsRun = 0;
    private static int testsPassed = 0;

    private static void assertEquals(Object expected, Object actual) {
        testsRun++;
        if (!expected.equals(actual)) {
            System.err.println("FAIL: Expected '" + expected + "' but got '" + actual + "'");
        } else {
            testsPassed++;
            System.out.println("PASS: " + expected);
        }
    }

    private static void assertEquals(int expected, int actual) {
        assertEquals(Integer.valueOf(expected), Integer.valueOf(actual));
    }

    private static void assertTrue(boolean condition) {
        testsRun++;
        if (!condition) {
            System.err.println("FAIL: Expected true but got false");
        } else {
            testsPassed++;
            System.out.println("PASS: true");
        }
    }

    private static void assertFalse(boolean condition) {
        testsRun++;
        if (condition) {
            System.err.println("FAIL: Expected false but got true");
        } else {
            testsPassed++;
            System.out.println("PASS: false");
        }
    }

    private static void fail(String message) {
        testsRun++;
        System.err.println("FAIL: " + message);
    }

    /**
     * @author teemuiljin
     * alustaa elokuvat
     */
    private static Elokuvat elokuvat;

    /**
     * @author teemuiljin
     * tekee ennen joka testiä elokuvat taulukon
     */
    private static void setUp() {
        elokuvat = new Elokuvat();
    }

    /**
     * @author teemuiljin
     * testaa lisää ja get lkm toimivuuden
     */
    public static void testLisaaJaGetLkm() {
        setUp();
        Elokuva elokuva = new Elokuva("Elokuva 1", "7.7", "2h 30m", "toiminta", "1");
        elokuvat.lisaa(elokuva);
        assertEquals(1, elokuvat.GetLkm());
    }

    /**
     * @author teemuiljin
     * testaa onko listaa muutettu uusilla elokuvilla tai poistolla
     */
    public static void testOnkoMuutettu() {
        setUp();
        assertFalse(elokuvat.OnkoMuutettu());
        elokuvat.Muutettu();
        assertTrue(elokuvat.OnkoMuutettu());
    }

    /**
     * @author teemuiljin
     * testaa poistaa elokuvan ja lisää elokuvan
     */
    public static void testPoista() {
        setUp();
        Elokuva elokuva1 = new Elokuva("Elokuva 1", "7.7", "2h 30m", "draama", "1");
        Elokuva elokuva2 = new Elokuva("Elokuva 2", "7.8", "2h 35m", "Toiminta", "2");
        elokuvat.lisaa(elokuva1);
        elokuvat.lisaa(elokuva2);

        elokuvat.poista(elokuva1);
        assertEquals(1, elokuvat.GetLkm());
    }

    /**
     * @author teemuiljin
     * testaa tallennaelokuvan tiedostoon ja tallentaa sen oikeaan tiedostoon
     * tehdään dummy elokuvat ja katsotaan toimiiko tulostus ja dat/bak filet
     */
    public static void testTallenna() {
        setUp();
        Elokuva elokuva1 = new Elokuva("Elokuva 1", "7.7", "2h 30m", "toiminta", "1");
        Elokuva elokuva2 = new Elokuva("Elokuva 2", "7.8", "2h 35m", "Draama", "2");
        elokuvat.lisaa(elokuva1);
        elokuvat.lisaa(elokuva2);
        try {
            elokuvat.tallenna();
            System.out.println("Tallennetut elokuvat:");
            Files.lines(Paths.get("Tiedostot/Elokuvat.dat")).forEach(System.out::println);
            elokuvat = new Elokuvat();
            elokuvat.lueTiedostosta();
            System.out.println("Ladatut leffat:");
            assertEquals(2, elokuvat.GetLkm());
        } catch (SailoException | IOException e) {
            fail("poikkeus: " + e.getMessage());
        }
    }

    /**
     * @author teemuiljin
     * testaan laskeimdb usealla elokuvalla ja varmistan toimivuuden
     */
    public static void testLaskeImdbUseallaElokuvalla() {
        setUp();
        List<Elokuva> testiElokuvat = new ArrayList<>();
        testiElokuvat.add(new Elokuva("Elokuva1", "8.0", "2h 30m", "toiminta", "1"));
        testiElokuvat.add(new Elokuva("Elokuva2", "7.5", "2h 10m", "draama", "2"));
        testiElokuvat.add(new Elokuva("Elokuva3", "6.5", "1h 50m", "komedia", "3"));
        for (Elokuva elokuva : testiElokuvat) {
            elokuvat.lisaa(elokuva);
        }
        assertEquals("7,3", elokuvat.LaskeImdb());
    }

    public static void main(String[] args) {
        System.out.println("Running Elokuvat tests...");
        testLisaaJaGetLkm();
        testOnkoMuutettu();
        testPoista();
        testTallenna();
        testLaskeImdbUseallaElokuvalla();
        System.out.println("\nTests completed: " + testsPassed + "/" + testsRun + " passed");
    }
}

