package ds.sort;

import java.util.Arrays;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class SelectionSort {


    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] arr) {

        int len = arr.length;

        if (len <= 1) {
            return;
        }
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }

    }

    private static void swap(int[] arr, int index, int j) {
        int temp = arr[index];
        arr[index] = arr[j];
        arr[j] = temp;
    }
}
