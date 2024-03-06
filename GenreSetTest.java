/**
 * 
 */
package dailymixes;

/**
 * @author nakyah
 * @version 04.03
 *
 */

public class GenreSetTest extends student.TestCase {
    private GenreSet test;
    private GenreSet other;

    /**
     * set up
     */
    public void setUp() {
        // pop, rock, country
        test = new GenreSet(20, 40, 40);
        other = new GenreSet(50, 50, 50);

    }


    /**
     * test pop
     */
    public void testGetPop() {
        assertEquals(test.getPop(), 20);
        assertEquals(other.getPop(), 50);

    }


    /**
     * test rock
     */
    public void testGetRock() {
        assertEquals(test.getRock(), 40);
        assertEquals(other.getRock(), 50);
        assertNotSame(test.getRock(), 20);
    }


    /**
     * test country
     */
    public void testGetCountry() {
        assertEquals(test.getCountry(), 40);
        assertNotSame(test.getCountry(), 30);
    }


    /**
     * tests within range
     */
    public void testIsWithinRange() {
        GenreSet less = new GenreSet(5, 5, 5);

        assertTrue(test.isWithinRange(less, other));

        // below range
        assertFalse(less.isWithinRange(other, test));
        assertTrue(less.isWithinRange(less, test));
        // above range
        assertFalse(other.isWithinRange(less, test));
        assertTrue(test.isWithinRange(less, test));
    }


    /**
     * tests equals method
     */
    public void testEquals() {
        GenreSet testE = new GenreSet(20, 40, 40);
        assertTrue(test.equals(test));
        assertFalse(test.equals(other));
        assertFalse(test.equals(null));
        assertFalse(test.equals("s:"));
        assertTrue(test.equals(testE));
        GenreSet testA = new GenreSet(20, 30, 40);
        assertFalse(testA.equals(test));
    }


    /**
     * compare to
     */
    public void testCompareTo() {
        // test: 100 || Other: 150
        assertEquals(test.compareTo(other), -1);
        assertEquals(other.compareTo(test), 1);
        assertEquals(other.compareTo(other), 0);

    }


    /**
     * test toString
     */
    public void testToString() {
        String strTest = ("Pop:20 Rock:40 Country:40");
        assertEquals(test.toString(), strTest);
    }

}
