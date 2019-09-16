package mergesort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        // [-22, -15, 1, 7, 20, 35, 55]
        assertEquals("[-22, -15, 1, 7, 20, 35, 55]", Arrays.toString(MergeSort.mergeSort(intArray, 0, intArray.length)));
    }

    @Test
    public void testMergeSort_emptyArray() {
        int[] intArray = { };

        assertNull(MergeSort.mergeSort(intArray, 0, intArray.length));

    }
}