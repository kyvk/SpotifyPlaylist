/**
 * 
 */
package dailymixes;

/**
 * @author nakyah
 * @version 04.13
 *
 */
public class PlaylistCalculatorTest extends student.TestCase {
    private PlaylistCalculator calc;
    private ArrayQueue<Song> songQueue;
    private Playlist[] playlists;
    private Playlist test0;
    private Playlist test1;
    private Song s1;
    private Song s2;

    /**
     * set up
     */
    public void setUp() {
        test0 = new Playlist("test0", 5, 5, 5, 10, 10, 10, 2);
        test1 = new Playlist("test1", 3, 3, 3, 5, 5, 5, 6);
        Playlist test2 = new Playlist("test2", 8, 8, 8, 12, 12, 12, 7);

        playlists = new Playlist[3];
        playlists[0] = test0;
        playlists[1] = test1;
        playlists[2] = test2;

        songQueue = new ArrayQueue<Song>();

        s1 = new Song("S1", 6, 6, 6, "test0");
        s2 = new Song("S2", 4, 4, 4, "test1");
        Song s3 = new Song("S3", 9, 9, 9, "test2");

        songQueue.enqueue(s1);
        songQueue.enqueue(s2);
        songQueue.enqueue(s3);

        calc = new PlaylistCalculator(songQueue, playlists);

    }


    /**
     * get queue
     */
    public void testGetQueue() {
        try {
            PlaylistCalculator g = new PlaylistCalculator(null, null);
            g.getQueue();
        }
        catch (IllegalArgumentException e1) {
            System.out.print("illegal");
        }

        assertEquals(songQueue, calc.getQueue());
    }


    /**
     * tests get playlists
     */
    public void testGetPlaylists() {
        assertEquals(calc.getPlaylists(), playlists);
    }


    /**
     * tests get index of playlist
     */
    public void testGetIndex() {
        assertEquals(calc.getPlaylistIndex("test0"), 0);
        assertEquals(calc.getPlaylistIndex("test"), -1);
    }


    /**
     * get playlist
     */
    public void testGetPlaylist() {
        assertNull(calc.getPlaylistForSong(null));

        assertEquals(calc.getPlaylistForSong(s1), test0);
        s1 = new Song("S1", 6, 6, 6, "");
        try {
            calc.getPlaylistForSong(s1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("illegal");
        }

        assertEquals(calc.getPlaylistForSong(s2), test1);

    }


    /**
     * tests add
     */
    public void testAdd() {
        ArrayQueue<Song> s = new ArrayQueue<Song>();
        PlaylistCalculator c = new PlaylistCalculator(s, playlists);
        assertFalse(c.addSongToPlaylist());
        assertTrue(calc.addSongToPlaylist());
    }


    /**
     * tests rejects
     * 
     */
    public void testReject() {
        calc.reject();
        assertEquals(songQueue.getSize(), 2);
    }
}
