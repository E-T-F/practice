package alg.sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr= new int[] {3,4,6,1,7,2,3};
//        selectionSort(arr);
//        bubbleSort(arr);
//        insertSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static void quickSort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int val = arr[start];
        while (left < right) {
            while (left < right && arr[right] >= val) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= val) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = val;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //插入的位置
            int insertIndex = i - 1;
            int insertVal = arr[i];
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //放合适的位置
            arr[insertIndex + 1] = insertVal;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }



    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
