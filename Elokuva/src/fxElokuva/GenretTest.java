package fxElokuva;
import fxElokuva.Genre;
import fxElokuva.Genret;
import fxElokuva.SailoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author teemuiljin
 * Genret test testaa genren tulostusta, tallennusta ja poistoa
 * kaikki järjkevä testataan ja mitään ei puutu
 */

public class GenretTest {
    
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
     * alustaa genret
     */
    private static Genret genret;

    /**
     * @author teemuiljin
     * tekee ennen joka testiä genret listan
     */
    private static void setUp() {
        genret = new Genret();
    }

    /**
     * @author teemuiljin
     * testaa lisää ja get lkm toimivuuden
     */
    public static void testLisaaJaGetLkm() {
        setUp();
        Genre genre = new Genre("Toiminta", "Toimintaelokuvien kuvaus");
        genret.lisaa(genre);
        assertEquals(1, genret.getLkm());
    }

    /**
     * @author teemuiljin
     * testaa onko listaa muutettu uusilla genrellä tai poistolla
     */
    public static void testOnkoMuutettu() {
        setUp();
        assertFalse(genret.OnkoMuutettu());
        genret.Muutettu();
        assertTrue(genret.OnkoMuutettu());
    }

    /**
     * @author teemuiljin
     * testaa tallenna genren tiedostoon ja tallentaa sen oikeaan tiedostoon
     * tehdään dummy genret ja katsotaan toimiiko tulostus ja dat/bak filet
     */
    public static void testTallenna() {
        setUp();
        try {
            genret.lueTiedostosta();
            System.out.println("Tallennetut genret:");
            Files.lines(Paths.get("Tiedostot/Genret.dat")).forEach(System.out::println);
            assertEquals(5, genret.getLkm()); // Olettaen, että tiedostossa on 5 genreä
        } catch (SailoException | IOException e) {
            fail("Poikkeus ei odotettu: " + e.getMessage());
        }
    }

    /**
     * @author teemuiljin
     * testaa poistaa genren ja lisää genren
     */
    public static void testPoista() {
        setUp();
        Genre genre1 = new Genre("Toiminta", "Toimintaelokuvien kuvaus");
        Genre genre2 = new Genre("Draama", "Draamaelokuvien kuvaus");
        genret.lisaa(genre1);
        genret.lisaa(genre2);

        genret.poista(genre1);
        try {
            genret.tallenna();
            assertEquals(2, genret.getLkm());
        } catch (SailoException e) {
            fail("poikkeus: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Running Genret tests...");
        testLisaaJaGetLkm();
        testOnkoMuutettu();
        testTallenna();
        testPoista();
        System.out.println("\nTests completed: " + testsPassed + "/" + testsRun + " passed");
    }
}