package code401challenges;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ArrayShiftTest {

    @Test
    public void insertShiftArray_evenArrayLengthHappy() {
        int[] testArray = new int[]{1,2,3,4};
        int num = 5;
        int[] expectedArray = new int[]{1,2,5,3,4};

        assertArrayEquals(expectedArray, ArrayShift.insertShiftArray(testArray, num));
    }

    @Test
    public void insertShiftArray_oddArrayLengthHappy() {
        int[] testArray = new int[]{1,2,3,4,5};
        int num = 6;
        int[] expectedArray = new int[]{1,2,6,3,4,5};

        assertArrayEquals(expectedArray, ArrayShift.insertShiftArray(testArray, num));
    }

    @Test
    public void insertShiftArray_evenArrayLengthFail() {
        int[] testArray = new int[]{1,2,3,4};
        int num = 5;
        int[] expectedArray = new int[]{1,2,3,4,5};

        assertThat("Arrays should NOT match!", expectedArray, is(not(ArrayShift.insertShiftArray(testArray, num))));
    }

    @Test
    public void insertShiftArray_oddArrayLengthFail() {
        int[] testArray = new int[]{1,2,3,4,5};
        int num = 6;
        int[] expectedArray = new int[]{1,2,3,4,5,6};

        assertThat("Arrays should NOT match!", expectedArray, is(not(ArrayShift.insertShiftArray(testArray, num))));
    }
}
