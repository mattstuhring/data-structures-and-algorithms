package quicksort;

// Resource -> UDEMY COURSE - Data Structures and Algorithms: Deep Dive Using Java
public class QuickSort {

    public static int[] quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return null;
        }

        int pivotIndex = partition(input, start, end);

        quickSort(input, start, pivotIndex);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

        quickSort(input, pivotIndex + 1, end);

        return input;
    }

    public static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: empty loop body
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }

            // NOTE: empty loop body
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }

}
