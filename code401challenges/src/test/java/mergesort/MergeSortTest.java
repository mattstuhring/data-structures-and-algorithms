package mergesort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        System.out.println(Arrays.toString(MergeSort.mergeSort(intArray, 0, intArray.length)));
    }
}