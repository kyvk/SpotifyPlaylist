package dailymixes;

import queue.EmptyQueueException;

/**
 * @author nakyahv
 * @version 04.05
 *
 */
public class ArrayQueueTest extends student.TestCase {
    private ArrayQueue<String> arrayQueue;
    private ArrayQueue<String> arrayQueue2;

    /**
     * set up
     */
    public void setUp() {
        arrayQueue = new ArrayQueue<String>();
        arrayQueue2 = new ArrayQueue<String>(10);

    }


    /**
     * testing clear
     */
    public void testClear() {
        arrayQueue.clear();
        assertEquals(arrayQueue.getSize(), 0);
        arrayQueue2.clear();
        assertEquals(arrayQueue2.getSize(), 0);
    }


    /**
     * tests to string
     */
    public void testToString() {
        assertTrue(arrayQueue.isEmpty());
        assertEquals(arrayQueue.toString(), "[]");
        arrayQueue.enqueue("Hello");
        arrayQueue.enqueue("Hello");
        String str = ("[Hello, Hello]");
        assertEquals(arrayQueue.toString(), str);
        assertTrue(arrayQueue2.isEmpty());
        assertEquals(arrayQueue2.toString(), "[]");
    }


    /**
     * tests to Array
     */
    public void testEquals() {
        // assertFalse(arrayQueue.equals(arrayQueue2));
        // assertTrue(arrayQueue.equals(arrayQueue));
        assertFalse(arrayQueue.equals(null));
        arrayQueue.enqueue("boo");
        arrayQueue2.enqueue("boo");
        assertTrue(arrayQueue.equals(arrayQueue));
        arrayQueue.enqueue("b");
        arrayQueue2.enqueue("b");

        assertTrue(arrayQueue.equals(arrayQueue));
        arrayQueue2.enqueue("b");
        assertFalse(arrayQueue.equals(arrayQueue2));
        assertFalse(arrayQueue.equals(2));
        //

        ArrayQueue<String> a = new ArrayQueue<String>();
        ArrayQueue<String> b = new ArrayQueue<String>();

        a.enqueue("first");
        b.enqueue("first");

        a.enqueue("second");
        b.enqueue("second");

        a.enqueue("third");
        b.enqueue("fourth");
        assertFalse(a.equals(b));
        assertEquals(a.getSize(), b.getSize());

        // assertTrue(A.equals(B));
    }


    /**
     * tests Dequeue
     */
    public void testDequeue() {
        Exception e = null;
        try {
            arrayQueue.dequeue();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof EmptyQueueException);

        arrayQueue.enqueue("Hello");
        arrayQueue.enqueue("Boo");
        arrayQueue.dequeue();
        assertEquals(arrayQueue.getSize(), 1);
    }


    /**
     * underlying array
     */
    public void testUnderlyingArray() {
        assertEquals(arrayQueue.getLengthOfUnderlyingArray(), 21);
        assertEquals(arrayQueue2.getLengthOfUnderlyingArray(), 11);
    }


    /**
     * test front
     */
    public void testFront() {
        Exception e = null;
        try {
            arrayQueue.getFront();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof EmptyQueueException);
        arrayQueue.enqueue("Hello");
        arrayQueue.enqueue("boo");
        // assertEquals(arrayQueue.getFront(), "boo");
    }


    /**
     * test to array
     */
    public void testToArray() {
        Exception e = null;
        try {
            arrayQueue.toArray();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof EmptyQueueException);

        arrayQueue.enqueue("Hello");
        arrayQueue.enqueue("boo");
        String[] array = { "Hello", "boo" };
        // String[] test = arrayQueue.toArray();

        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], (arrayQueue.toArray()[i]));
        }

    }


    /**
     * tests ensure capacity
     */
    public void testEnsureCapacity() {
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        arrayQueue.enqueue("enqueue");
        assertEquals(arrayQueue.getSize(), 22);

    }

}
