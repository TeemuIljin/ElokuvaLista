package fxElokuva;

import fxElokuva.Elokuva;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Elokuvatest luokka, testata elokuvien ominaisuuksia
 * yksi neljästä testiluokasta ja kaikkea järkevää testataan tässä luokassa
 */
public class ElokuvaTest {
    
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

    /**
     * @author teemuiljin
     * testaa elokuvan tietoja tulostusmuotoa
     */
    public static void testTietojaElokuva() {
        Elokuva elokuva = new Elokuva("Pulp Fiction", "8.9", "2h 34min", "Draama", "1");
        String expected = " Nimi: Pulp Fiction, imdb: 8.9, Kesto: 2h 34min, genre: Draama, ID: 1";
        assertEquals(expected, elokuva.tietojaElokuva());
    }

    /**
     * @author teemuiljin
     * testaa parsea ja toimivuutta tulostuksessa
     */
    public static void testParse() {
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
    public static void testToString() {
        Elokuva elokuva = new Elokuva("Avatar", "7.8", "2h 42min", "Sci-Fi", "3");
        assertEquals("Avatar | 7.8 | 2h 42min | Sci-Fi | 3", elokuva.toString());
    }

    public static void main(String[] args) {
        System.out.println("Running Elokuva tests...");
        testTietojaElokuva();
        testParse();
        testToString();
        System.out.println("\nTests completed: " + testsPassed + "/" + testsRun + " passed");
    }
}
