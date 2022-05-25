package com.etf.utils;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

//        int[] arr = new int[]{1, 234, 4, 53, 3, 5};
        int[] arr= new int[] {3,4,6,1,7,2,3};


        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        quickSortWithPartition(arr, 0, arr.length - 1);

    }

    private static void quickSortWithPartition(int[] arr, int start, int end) {
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
           if (val > arr[right]) {
               int temp = arr[right];
               arr[right] = arr[left];
               arr[left] = temp;
           }
           while (left < right && arr[left] <= val) {
               left++;
           }
           if (val < arr[left]) {
               int temp = arr[right];
               arr[right] = arr[left];
               arr[left] = temp;
           }
       }
       quickSortWithPartition(arr, start, left - 1);
       quickSortWithPartition(arr, left + 1, end);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
