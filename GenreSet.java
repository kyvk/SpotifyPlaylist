/**
 * 
 */
package dailymixes;

/**
 * @author nakyahv
 * @version 04.03
 *
 */
public class GenreSet implements Comparable<GenreSet> {
    private int rock;
    private int pop;
    private int country;

    /**
     * @param pop
     *            pop percentage
     * @param rock
     *            rock percentage
     * @param country
     *            country percentage
     */
    public GenreSet(int pop, int rock, int country) {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }


    /**
     * @return pop int
     */
    public int getPop() {
        return pop;
    }


    /**
     * @return rock int
     */
    public int getRock() {
        return rock;
    }


    /**
     * @return country int
     */
    public int getCountry() {
        return country;
    }


    /**
     * @param other
     * @return boolean true if genres are less then or equal to other's
     *         method can be used for checking if a song's genreset is accepted
     *         based on a playlist's required genreset range.
     */
    private boolean isLessThanOrEqualTo(GenreSet other) {
        /*
         * if (this.rock <= other.rock && this.pop <= other.pop
         * && this.country <= other.country) {
         * return true;
         * }
         * else {
         * return false;
         * }
         */
        return this.rock <= other.rock && this.pop <= other.pop
            && this.country <= other.country;

    }


    /**
     * @param minGenreSet
     *            minimum
     * @param maxGenreSet
     *            maximum
     * @return boolean
     * 
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet) {

        /*
         * if (isLessThanOrEqualTo(maxGenreSet) && this.rock >= minGenreSet.rock
         * && this.pop >= minGenreSet.pop
         * && this.country >= minGenreSet.country) {
         * return true;
         * }
         */

        return (isLessThanOrEqualTo(maxGenreSet)
            && this.rock >= minGenreSet.rock && this.pop >= minGenreSet.pop
            && this.country >= minGenreSet.country);

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
            GenreSet other = (GenreSet)obj;
            return this.rock == other.rock && this.pop == other.pop
                && this.country == other.country;
            /*
             * if (this.rock == other.rock && this.pop == other.pop
             * && this.country == other.country) {
             * return true;
             * }
             */
            // return false;
        }
        return false;

    }


    /**
     * @param other
     *            genreset
     * 
     * @return the result
     *         - ->less than
     *         0-> equal
     *         +-> more than
     */
    @Override
    public int compareTo(GenreSet other) {
        // sum of genre comp comapred to genre other comp
        int sumThis = this.country + this.pop + this.rock;
        int sumOther = other.country + other.pop + other.rock;

        if (sumOther > sumThis) {
            return -1;
        }
        else if (sumThis > sumOther) {
            return 1;
        }
        else {
            return 0;
        }
    }


    /**
     * to string method
     * 
     * @return data in a string
     */
    public String toString() {
        StringBuilder s = new StringBuilder("");

        // pop
        s.append("Pop:" + pop + " Rock:" + rock + " Country:" + country);
        return s.toString();
    }

}
