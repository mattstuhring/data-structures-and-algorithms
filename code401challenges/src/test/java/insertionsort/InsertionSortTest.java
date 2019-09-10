package insertionsort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void testInsertionSort_singleDigitNumbers() {
        int[] arr = new int[]{1,6,2,8,4,3,7,9,5};

        InsertionSort is = new InsertionSort();

        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(is.insertionSort(arr)));
    }

    @Test
    public void testInsertionSort_doubleDigitNumbers() {
        int[] arr = new int[]{10,67,22,80,44,31,78,96,55};

        InsertionSort is = new InsertionSort();

        // [10, 22, 31, 44, 55, 67, 78, 80, 96]
        assertEquals("[10, 22, 31, 44, 55, 67, 78, 80, 96]", Arrays.toString(is.insertionSort(arr)));
    }

    @Test
    public void testInsertionSort_mixedPositiveNumbers() {
        int[] arr = new int[]{1001,647,2,8880,42,30001,178,6,55};

        InsertionSort is = new InsertionSort();

        // [2, 6, 42, 55, 178, 647, 1001, 8880, 30001]
        assertEquals("[2, 6, 42, 55, 178, 647, 1001, 8880, 30001]", Arrays.toString(is.insertionSort(arr)));
    }

    @Test
    public void testInsertionSort_emptyArray() {
        int[] arr = new int[]{};

        InsertionSort is = new InsertionSort();

        // []
        assertEquals("[]", Arrays.toString(is.insertionSort(arr)));
    }

    @Test
    public void testInsertionSort_negativeNumbers() {
        int[] arr = new int[]{-1,-6,-2,-8,-4,-3,-7,-9,-5};

        InsertionSort is = new InsertionSort();

        // [-9, -8, -7, -6, -5, -4, -3, -2, -1]
        assertEquals("[-9, -8, -7, -6, -5, -4, -3, -2, -1]", Arrays.toString(is.insertionSort(arr)));
    }

    @Test
    public void testInsertionSort_mixedPositiveAndNegativeNumbers() {
        int[] arr = new int[]{-1,6,-20,81,-4,303,77,-90,9};

        InsertionSort is = new InsertionSort();

        // [-90, -20, -4, -1, 6, 9, 77, 81, 303]
        assertEquals("[-90, -20, -4, -1, 6, 9, 77, 81, 303]", Arrays.toString(is.insertionSort(arr)));
    }





}