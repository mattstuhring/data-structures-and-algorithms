package code401challenges;

public class ArrayShift {

    public static int[] insertShiftArray(int[] arr, int num) {
        int[] resultArr = new int[arr.length + 1];
        int middleIndex = (arr.length + 1) / 2;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == middleIndex) {
                resultArr[i] = num;
                count++;
            }

            resultArr[count] = arr[i];
            count++;
        }

        return resultArr;
    }
}
