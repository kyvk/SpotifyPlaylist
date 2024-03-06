/**
 * 
 */
package dailymixes;

/**
 * @author nakyah
 * @version 04.03.23
 *
 */
public class Song {
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    /**
     * @param name
     *            name of song
     * @param pop
     *            pop percentage
     * @param rock
     *            rock percentage
     * @param country
     *            country percentage
     * @param suggestedPlaylist
     *            suggested playlist
     */
    public Song(
        String name,
        int pop,
        int rock,
        int country,
        String suggestedPlaylist) {
        this.name = name;
        this.suggestedPlaylist = suggestedPlaylist;
        genreSet = new GenreSet(pop, rock, country);
    }


    /**
     * @return suggested playlist's name
     */
    public String getPlaylistName() {
        return suggestedPlaylist;
    }


    /**
     * @return song in a string
     */
    public String toString() {
        StringBuilder s = new StringBuilder("");
        s.append(name + " Pop:" + genreSet.getPop() + " Rock:" + genreSet
            .getRock() + " Country:" + genreSet.getCountry());
        if (suggestedPlaylist.length() > 0) {
            s.append(" Suggested:" + suggestedPlaylist);
        }
        return s.toString();
    }


    /**
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * @return genreSet
     */
    public GenreSet getGenreSet() {
        return genreSet;
    }


    /**
     * @param obj
     *            Object
     * @return boolean
     *         true of equals
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {

            Song other = (Song)obj;
            return (this.getGenreSet().equals(other.getGenreSet()) && this
                .getName() == other.getName() && this.getPlaylistName().equals(
                    other.getPlaylistName()));

            /*
             * if (this.getGenreSet().equals(other.getGenreSet()) && this
             * .getName() == other.getName() && this.getPlaylistName().equals(
             * other.getPlaylistName())) {
             * 
             * return true;
             * 
             * }
             */
            // return false;
        }
        return false;

    }
}
