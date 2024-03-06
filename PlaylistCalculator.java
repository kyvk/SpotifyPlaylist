/**
 * 
 */
package dailymixes;

import java.util.Arrays;
import list.AList;

/**
 * @author nakyah
 * @version 04.18
 *
 */
public class PlaylistCalculator {
    private Playlist[] playlists;
    /**
     * number of playlists
     */
    public static final int NUM_PLAYLISTS = 3;

    /**
     * min percents
     */
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;

    /**
     * max percent
     */
    public static final int MAX_PERCENT = 100;

    /**
     * @param songQueue
     *            songs in a queue
     * @param playlists
     *            playlit array
     */
    public PlaylistCalculator(
        ArrayQueue<Song> queue,
        Playlist[] paramPlaylists) {
        if (queue == null) {
            throw new IllegalArgumentException();
        }
        playlists = paramPlaylists;
        songQueue = queue;
        rejectedTracks = new AList<Song>();

    }


    /**
     * @return the songQueue
     */
    public ArrayQueue<Song> getQueue() {
        return songQueue;
    }


    /**
     * @return playlists
     */
    public Playlist[] getPlaylists() {
        return playlists;

    }


    /**
     * @param newSong
     *            a new song
     * @return the playlist or null
     */
    private Playlist getPlaylistWithMostRoom(Song newSong) {
        Playlist[] temp = Arrays.copyOf(playlists, NUM_PLAYLISTS);
        Arrays.sort(temp);
        for (int i = 0; i < NUM_PLAYLISTS; i++) {
            if (!(temp[i].isFull()) && temp[i].isQualified(newSong)) {
                return temp[i];
            }
        }

        return null;
    }


    /**
     * @param playlist
     *            a playlist
     * @return the playlist or -1
     */
    public int getPlaylistIndex(String playlist) {
        for (int i = 0; i < NUM_PLAYLISTS; i++) {
            if (playlists[i].getName().equals(playlist)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * @param nextSong
     *            song that is next
     * @return playlist thats best for the song
     */
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }
        if (nextSong.getPlaylistName().equals("")) {
            int temp = getPlaylistIndex(nextSong.getPlaylistName());
            Playlist get = playlists[temp];
            if (!(get.isFull()) && get.isQualified(nextSong)) {
                return get;
            }
            else {
                return null;
            }
        }
        else {
            return getPlaylistWithMostRoom(nextSong);
        }
    }


    /**
     * @return if the song is added to playlist or not
     */
    public boolean addSongToPlaylist() {
        if (!(songQueue.isEmpty())) {

            Playlist suggested = getPlaylistForSong(songQueue.getFront());
            if (suggested != null) {
                suggested.addSong(songQueue.getFront());
                songQueue.dequeue();
                return true;
            }
        }
        return false;
    }


    /**
     * rejects a playlist
     */
    public void reject() {
        rejectedTracks.add(songQueue.getFront());
        songQueue.dequeue();
    }

}
