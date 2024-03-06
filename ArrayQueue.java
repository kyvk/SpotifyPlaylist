/**
 * 
 */
package dailymixes;

import java.util.Arrays;
import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * @author nakyahv
 * @version 04.05.23
 * @param <T>
 *
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    /**
     * sets default cpacity
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    /**
     * @param initial
     *            capacity of the queue
     * 
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initial) {
        // DEFAULT_CAPACITY = initial;
        /*
         * dequeueIndex = 0;
         * enqueueIndex = 1;
         * queue = (T[])new Object[initial + 1];
         */
        this.queue = (T[])new Object[initial + 1];
        this.dequeueIndex = 0;
        this.enqueueIndex = queue.length - 1;

        size = 0;
    }


    /**
     * constructor
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);

    }


    /**
     * clears
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        size = 0;
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];

    }


    /**
     * @param index
     * @return int
     *         increments the index
     */
    private int incrementIndex(int index) {

        return ((index + 1) % queue.length);
    }


    /**
     * to string method
     * 
     * @return a string of the elements in queue
     */
    public String toString() {

        String s = ("[");
        if (!this.isEmpty()) {
            Object[] str = this.toArray();
            s = s + str[0].toString();
            for (int i = 1; i < str.length; i++) {
                s = s + ", " + str[i];

            }
        }
        s = s + "]";

        return s;

    }


    /**
     * equals method
     * 
     * @return a boolean
     * @param obj
     *            Object
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)obj;
            if (this.size != other.getSize()) {
                return false;
            }

            if (this.toArray().length == other.toArray().length && (Arrays
                .equals(this.toArray(), other.toArray()))) {

                return true;

            }
        }

        return false;
    }


    /**
     * checks if empty
     */
    @Override
    public boolean isEmpty() {
        /*
         * boolean empty = false;
         * if (size == 0 || dequeueIndex == -1) {
         * empty = true;
         * }
         */

        return size == 0;
    }


    /**
     * remove from back of queue
     */
    @Override
    // throw EmptyQueueException
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        // T removed = queue[dequeueIndex];
        T removed = getFront();
        queue[dequeueIndex] = null;
        /*
         * if (dequeueIndex == enqueueIndex) {
         * dequeueIndex = -1;
         * enqueueIndex = -1;
         * }
         */
        dequeueIndex = incrementIndex(dequeueIndex);

        size--;
        return removed;
    }


    /**
     * ensures the capacity
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if ((enqueueIndex + 2) % queue.length == dequeueIndex) {
            T[] temp = queue;

            int updatedSize = 2 * temp.length - 1;
            queue = (T[])new Object[updatedSize];

            int j = dequeueIndex;
            for (int i = 0; i < temp.length; i++) {
                queue[i] = temp[i];
                j = (j + 1) % temp.length;
            }
            enqueueIndex = temp.length - 2;
            dequeueIndex = 0;

        }

    }


    /**
     * adds to queue
     * 
     * @param entry
     */
    @Override
    public void enqueue(T entry) {

        if (isFull()) {
            ensureCapacity();
        }
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = entry;
        size++;

    }


    /**
     * @return length of underlying array
     */
    public int getLengthOfUnderlyingArray() {

        return queue.length;
    }


    @Override
    // throw EmptyQueueException
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * @return size of array queue
     */
    public int getSize() {
        return size;
    }


    /**
     * @return boolean
     */
    private boolean isFull() {

        return incrementIndex(enqueueIndex) == dequeueIndex;
    }


    /**
     * @return To array
     */

    public Object[] toArray() {

        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[this.size];
        int index = (dequeueIndex);

        for (int i = 0; i < this.size; i++) {

            array[i] = queue[index];
            index = incrementIndex(index);
        }

        return array;

    }

}
