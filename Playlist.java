/**
 * 
 */
package dailymixes;

/**
 * @author nakyahv
 * @version 04/09
 *
 */
public class Playlist implements Comparable<Playlist> {
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    /**
     * @param playlistName
     *            name of playlist
     * @param minPop
     *            minimum pop
     * @param minRock
     *            minimum rock
     * @param minCountry
     *            min for country
     * @param maxPop
     *            max for pop
     * @param maxRock
     *            max rock
     * @param maxCountry
     *            max country
     * @param playlistCap
     *            playlist capacity
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap) {

        numberOfSongs = 0;
        capacity = playlistCap;
        name = playlistName;
        songs = new Song[capacity];

        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);

    }


    /**
     * @return minGenreSet
     */
    public GenreSet getMinGenreSet() {
        return minGenreSet;
    }


    /**
     * @param entry
     *            sets the song name
     */
    public void setName(String entry) {
        name = entry;

    }


    /**
     * @return max genreset
     */
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }


    /**
     * @param other
     *            playlist that is being compared to current playlist
     * @return an int 0
     */
    @Override
    public int compareTo(Playlist other) {
        if (this.capacity != other.capacity) {
            return this.capacity - other.capacity;
        }
        else if (this.getSpacesLeft() != other.getSpacesLeft()) {
            return this.getSpacesLeft() - other.getSpacesLeft();
        }
        else if (this.minGenreSet.compareTo(other.minGenreSet) != 0) {
            return this.minGenreSet.compareTo(other.minGenreSet);
        }
        else if (this.maxGenreSet.compareTo(other.maxGenreSet) != 0) {
            return this.maxGenreSet.compareTo(other.maxGenreSet);
        }
        else if (this.getName() != other.getName()) {
            return this.getName().compareTo(other.getName());
        }
        else {
            return 0;
        }

    }


    /**
     * @return the number of spaces left in the array
     */
    public int getSpacesLeft() {
        return capacity - numberOfSongs;
    }


    /**
     * @return the number of songs in the playlist
     */
    public int getNumberOfSongs() {
        return numberOfSongs;
    }


    /**
     * @return the name of playlist
     */
    public String getName() {
        return name;
    }


    /**
     * @return an array
     */
    public Song[] getSongs() {

        return songs;

    }


    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * @param newSong
     *            song to be added
     * @return if song was added successfully
     */
    public boolean addSong(Song newSong) {
        if (!isFull() && newSong.getGenreSet().isWithinRange(minGenreSet,
            maxGenreSet)) {

            songs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true;

        }
        return false;

    }


    /**
     * @return s.tostring
     *         a string
     */
    public String toString() {
        StringBuilder s = new StringBuilder("");
        s.append("Playlist:" + name + ", ");
        s.append("# of songs:" + numberOfSongs);
        s.append(" (cap:" + capacity + "), ");
        s.append("Requires: Pop:" + minGenreSet.getPop() + "%-" + maxGenreSet
            .getPop() + "%, ");
        s.append("Rock:" + minGenreSet.getRock() + "%-" + maxGenreSet.getRock()
            + "%, ");
        s.append("Country:" + minGenreSet.getCountry() + "%-" + maxGenreSet
            .getCountry() + "%");

        return s.toString();
    }


    /**
     * @return if the array is at capacity
     */
    public boolean isFull() {
        return numberOfSongs == capacity;
    }


    /**
     * @param obj
     *            object that is being compared
     * @return a boolean if true or false
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            Playlist other = (Playlist)obj;

            if (this.compareTo(other) == 0) {
                return true;
            }
        }
        return false;

    }


    /**
     * @param possibleSong
     *            seeing if the song can be added based on parameters
     * @return yes or no
     */
    public boolean isQualified(Song possibleSong) {
        return possibleSong.getGenreSet().isWithinRange(minGenreSet,
            maxGenreSet);

    }

}
