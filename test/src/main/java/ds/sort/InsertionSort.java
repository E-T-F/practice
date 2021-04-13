package ds.sort;

import java.util.Arrays;

public class InsertionSort {



    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] arr) {

        int len = arr.length;
        if (len <= 1) {
            return;
        }

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int val = arr[i];
            for (; j >= 0; --j) {
                if (val < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
        }
    }
}
