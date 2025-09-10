package fxElokuva;

/**
 * @author teemuiljin Email: teemu.iljin@gmail.com
 * Genretest luokka, jossa testataan genrejen toimintaa, parsea ja tulostusta yms.
 * ei puutu mitään
 */
public class GenreTest {
    
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
     * testaan tietojagenreä ja sen tulostuksen oikeellisuutta
     */
    public static void testTietojaGenre() {
        Genre genre = new Genre("Draama", "Tämä on draaman kuvaus",1);
        String expected = " Tiedot: Tämä on draaman kuvaus, Genre: Draama, Genren ID: 1";
        assertEquals(expected, genre.tietojaGenre());
    }

    /**
     * @author teemuiljin
     * testaan parsea ja tulostuksen toimintaa
     * odotan arvoa ja saan odotetun arvon
     */
    public static void testParse() {
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
    public static void testToString() {
        Genre genre = new Genre("Komedia", "Tämä on komedian kuvaus", 3);
        assertEquals("Tämä on komedian kuvaus|Komedia|3", genre.toString());
    }

    public static void main(String[] args) {
        System.out.println("Running Genre tests...");
        testTietojaGenre();
        testParse();
        testToString();
        System.out.println("\nTests completed: " + testsPassed + "/" + testsRun + " passed");
    }
}