package main;

/**
 * This class is something like an {@link java.util.ArrayList}.
 */
public class Sequence {

    private int[] intArray;

    /**
     * Constructor to create a int sequence of a given size.
     *
     * @param size
     */
    public Sequence(int size) {
        intArray = new int[size];
    }

    /**
     * Constructor to create a sequence of the given values.
     *
     * @param values
     */
    public Sequence(int... values) {
        intArray = values;
    }

    /**
     * Sets the given at a given position of the sequence;
     *
     * @param pos position, where to set the value
     * @param val
     */
    public void set(int pos, int val) {

        // Make sure, the array is big enough
        while (pos >= intArray.length) {
            intArray = new int[intArray.length * 2];
        }

        // Set the value at the given position
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = val;
        }
    }

    /**
     * Returns a string representation of the sequence, in the following format:
     * |1 4 9 16 9 7 4 9 11|
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('|');
        for (int i = 0; i < intArray.length; i++) {
            stringBuilder.append(i);
            if (i < intArray.length - 1) {
                stringBuilder.append(' ');
            }
        }
        stringBuilder.append('|');

        return stringBuilder.toString();
    }
}
