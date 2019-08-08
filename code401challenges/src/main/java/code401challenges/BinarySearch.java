package code401challenges;

public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        int max = arr.length - 1;
        int min = 0;

        while (min <= max) {

            int mid = (max + min) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            }
        }

        return -1;
    }
}
