package code401challenges;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void binarySearch_evenLengthArray_keyExists() {
        int[] testArray = new int[]{4,8,15,16,23,42};
        int key = 15;
        int expectedIndex = 2;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }

    @Test
    public void binarySearch_oddLengthArray_keyExists() {
        int[] testArray = new int[]{11,22,33,44,55,66,77};
        int key = 55;
        int expectedIndex = 4;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }

    @Test
    public void binarySearch_evenLengthArray_keyDoesNotExist() {
        int[] testArray = new int[]{4,8,15,16,23,42};
        int key = 43;
        int expectedIndex = -1;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }

    @Test
    public void binarySearch_oddLengthArray_keyDoesNotExist() {
        int[] testArray = new int[]{11,22,33,44,55,66,77};
        int key = 99;
        int expectedIndex = -1;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }

    @Test
    public void binarySearch_evenLengthArray_keyAtStartOfArray() {
        int[] testArray = new int[]{4,8,15,16,23,42};
        int key = 4;
        int expectedIndex = 0;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }

    @Test
    public void binarySearch_oddLengthArray_keyAtStartOfArray() {
        int[] testArray = new int[]{11,22,33,44,55,66,77};
        int key = 11;
        int expectedIndex = 0;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }

    @Test
    public void binarySearch_evenLengthArray_keyAtEndOfArray() {
        int[] testArray = new int[]{4,8,15,16,23,42};
        int key = 42;
        int expectedIndex = 5;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }

    @Test
    public void binarySearch_oddLengthArray_keyAtEndOfArray() {
        int[] testArray = new int[]{11,22,33,44,55,66,77};
        int key = 77;
        int expectedIndex = 6;

        assertEquals(expectedIndex, BinarySearch.binarySearch(testArray, key));
    }
}