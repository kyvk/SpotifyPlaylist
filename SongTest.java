/**
 * 
 */
package dailymixes;

/**
 * @author nakyahv
 * @version 04.05.23
 *
 */
public class SongTest extends student.TestCase {
    private Song test;

    /**
     * set up
     */
    public void setUp() {
        test = new Song("Testing", 20, 30, 50, "D!");

    }


    /**
     * test playlist name
     */
    public void testPlaylist() {
        assertEquals(test.getPlaylistName(), "D!");
        assertNotSame(test.getPlaylistName(), "boo");
    }


    /**
     * testing to string
     */
    public void testToString() {
        String str = "Testing Pop:20 Rock:30 Country:50 Suggested:D!";
        assertEquals(test.toString(), str);

        Song toS = new Song("String", 20, 30, 50, "");
        String str1 = ("String Pop:20 Rock:30 Country:50");
        assertEquals(toS.toString(), str1);
    }


    /**
     * testing getName
     */
    public void testGetName() {
        assertEquals(test.getName(), "Testing");
        assertNotSame(test.getName(), "boo");
    }


    /**
     * testGenre
     */
    public void testGenre() {
        GenreSet gs = new GenreSet(20, 30, 50);
        assertEquals(test.getGenreSet(), gs);

    }


    /**
     * testEquals
     */
    public void testEquals() {
        Song a = new Song("Testing", 20, 30, 50, "D!");
        Song b = new Song("B", 40, 60, 0, "Bee");
        Song c = new Song("C", 40, 60, 0, "Bee");
        Song d = new Song("C", 40, 60, 0, "d");
        assertTrue(test.equals(test));

        assertEquals(a.getGenreSet(), test.getGenreSet());
        assertEquals(a.getName(), test.getName());
        assertTrue(test.equals(a));
        assertFalse(a.equals(null));
        assertFalse(a.equals("boo"));
        assertFalse(a.equals(b));
        assertFalse(c.equals(b));
        assertFalse(c.equals(d));

    }
}
