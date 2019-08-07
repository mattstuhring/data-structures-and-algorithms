package code401challenges;

import java.util.Arrays;

public class ArrayReverse {

  public static void main(String[] args) {
    int[] toBeReversed = new int[]{1,2,3,4,5};
    System.out.println(Arrays.toString((reverseArray(toBeReversed))));

  }

  public static int[] reverseArray(int[] arr) {
    int[] reversedArr = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      reversedArr[i] = arr[(arr.length - 1) - i];
    }

    return reversedArr;
  }
}