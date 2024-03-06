/**
 * 
 */
package dailymixes;

/**
 * @author nakyah
 * @version 04.11
 *
 */
public class PlaylistTest extends student.TestCase {
    private Playlist p1;
    private GenreSet minP1;
    private GenreSet maxP1;
    private Song s1;

    /**
     * set up
     */
    public void setUp() {
        p1 = new Playlist("P1", 20, 20, 20, 40, 40, 40, 60);
        minP1 = new GenreSet(20, 20, 20);
        maxP1 = new GenreSet(40, 40, 40);
        s1 = new Song("Hello", 20, 20, 20, "P1");
    }


    /**
     * test get min genre set
     */
    public void testGetMin() {

        assertEquals(minP1, p1.getMinGenreSet());

    }


    /**
     * set name test
     */
    public void testSetName() {
        p1.setName("test");
        assertEquals(p1.getName(), "test");
    }


    /**
     * test get Max
     */
    public void testGetMax() {
        assertEquals(p1.getMaxGenreSet(), maxP1);
    }


    /**
     * tests compare method
     */
    public void testCompare() {

        // exactly same
        Playlist p2 = new Playlist("P1", 20, 20, 20, 40, 40, 40, 60);
        assertEquals(p1.compareTo(p2), 0);

        // capacity
        Playlist p3 = new Playlist("P1", 20, 20, 20, 40, 40, 40, 70);
        Playlist p4 = new Playlist("P1", 20, 20, 20, 40, 40, 40, 50);
        assertEquals(p3.compareTo(p4), 20);
        assertEquals(p4.compareTo(p3), -20);

        // spaces left

        p1.addSong(s1);
        assertEquals(p2.compareTo(p1), 1);

        // minGenre
        Playlist p5 = new Playlist("P1", 50, 50, 50, 60, 60, 60, 50);

        assertEquals(p5.compareTo(p4), 1);

        // max genre set
        Playlist p6 = new Playlist("P1", 20, 20, 20, 60, 60, 60, 50);
        assertEquals(p6.compareTo(p4), 1);

        // name
        Playlist p7 = new Playlist("P2", 20, 20, 20, 60, 60, 60, 50);
        assertEquals(p7.compareTo(p6), 1);

    }


    /**
     * get spaces left
     */
    public void testSpacesLeft() {

        assertEquals(p1.getSpacesLeft(), 60);
        assertNotSame(p1.getSpacesLeft(), 0);
    }


    /**
     * tests number of songs
     */
    public void testNumberOfSongs() {
        assertEquals(p1.getNumberOfSongs(), 0);
        p1.addSong(s1);
        assertEquals(p1.getNumberOfSongs(), 1);

    }


    /**
     * test get songs
     */
    public void testgetSongs() {

        assertEquals(p1.getSongs()[0], null);

    }


    /**
     * test capacity
     */
    public void testGetCapcity() {
        assertEquals(p1.getCapacity(), 60);

    }


    /**
     * test add
     */
    public void testAddSong() {
        Playlist addTest = new Playlist("P1", 20, 20, 20, 40, 40, 40, 2);
        Song s2 = new Song("Apartment", 20, 20, 20, "P1");
        addTest.addSong(s2);
        addTest.addSong(s1);
        assertFalse(addTest.addSong(s2));

    }


    /**
     * tests To string
     */
    public void testToString() {
        String str =
            "Playlist:P1, # of songs:0 (cap:60), Requires: Pop:20%-40%, Rock:20%-40%, Country:20%-40%";
        assertEquals(p1.toString(), str);
    }


    /**
     * test Equals
     */
    public void testEquals() {
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(null));
        assertFalse(p1.equals(maxP1));
        Playlist p2 = new Playlist("P1", 20, 20, 20, 40, 40, 40, 60);
        assertTrue(p1.equals(p2));
        Playlist p7 = new Playlist("P2", 20, 20, 20, 60, 60, 60, 50);
        assertFalse(p7.equals(p2));
    }
}
