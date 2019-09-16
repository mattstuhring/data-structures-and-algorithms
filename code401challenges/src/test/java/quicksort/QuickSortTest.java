package quicksort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        // [-22, -15, 1, 7, 20, 35, 55]
        assertEquals("[-22, -15, 1, 7, 20, 35, 55]", Arrays.toString(QuickSort.quickSort(intArray, 0, intArray.length)));
    }

    @Test
    public void testQuickSort_emptyArray() {
        int[] intArray = new int[]{};

        assertNull(QuickSort.quickSort(intArray, 0, intArray.length));
    }
}