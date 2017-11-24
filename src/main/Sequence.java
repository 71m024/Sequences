package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
     * Sets the value given at a given position of the sequence;
     *
     * @param pos position, where to set the value
     * @param val value
     */
    public void set(int pos, int val) {

        // Make sure, the array is big enough
        if (pos >= intArray.length) {
            intArray = Arrays.copyOf(intArray, intArray.length * 2);
        }

        // Set the value at the given position
        intArray[pos] = val;
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
            stringBuilder.append(intArray[i]);
            if (i < intArray.length - 1) {
                stringBuilder.append(' ');
            }
        }
        stringBuilder.append('|');

        return stringBuilder.toString();
    }

    /**
     * Checks, if the two sequences contain the same values in the same order.
     *
     * @param other object to compare with this instance
     * @return
     */
    public boolean isEqual(Sequence other) {
        return Arrays.equals(intArray, other.intArray);
    }

    /**
     * Checks, if both sequences contain the same values, ignoring duplicates.
     *
     * @param other sequences, to campare this with
     * @return
     */
    public boolean hasSameValues(Sequence other) {

        // Remove duplicates and sort both arrays
        int[] sortedValuesA = getSorted(removeDuplicates(intArray));
        int[] sortedValuesB = getSorted(removeDuplicates(other.intArray));

        return Arrays.equals(sortedValuesA, sortedValuesB);
    }

    /**
     * Removes all duplicated values in the given array.
     * No equals only ==
     *
     * @param array
     * @return
     */
    private int[] removeDuplicates(int[] array) {
        HashSet<Integer> intValuesA = new HashSet<Integer>(); // create hashSet from array

        // add all values from the hashSet to the array
        for (int i = 0; i < intArray.length; i++) {
            intValuesA.add(intArray[i]);
        }

        // convert the hashSet into a int array
        return intValuesA.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Sort the array and return it
     *
     * @param array
     * @return
     */
    private int[] getSorted(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public boolean isPermutationOf(Sequence other) {

        boolean isPermutation = true;

        // count all values in the array and store it in a hash map
        HashMap<Integer, Integer> valueCounter = new HashMap<>();
        for (int i = 0; i < intArray.length; i++) {
            if (valueCounter.containsKey(intArray[i])) {
                valueCounter.put(intArray[i], valueCounter.get(intArray[i]) + 1);
            } else {
                valueCounter.put(intArray[i], 1);
            }
        }

        // remove all counts of the other array
        for (int i = 0; i < other.intArray.length; i++) {
            if (valueCounter.containsKey(other.intArray[i]) && valueCounter.get(other.intArray[i]) == 1) {
                valueCounter.remove(intArray[i]);
            } else if (valueCounter.containsKey(other.intArray[i]) && valueCounter.get(other.intArray[i]) > 1) {
                valueCounter.put(other.intArray[i], valueCounter.get(other.intArray[i]) - 1);
            } else {
                isPermutation = false;
            }
            if (!valueCounter.isEmpty()) {
                isPermutation = false;
            }
        }

        return isPermutation;
    }

}
