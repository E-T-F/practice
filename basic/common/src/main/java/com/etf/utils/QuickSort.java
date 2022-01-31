package com.etf.utils;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 234, 4, 53, 3, 5};


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
        int value = arr[left];
        while (start < end) {
            while (start < end && arr[end] > value) {
                end--;
            }
            while (start < end && arr[start] < value) {
                start++;
            }
            swap(arr, start, end);
        }
        arr[start] = value;

        quickSortWithPartition(arr, left, start - 1);
        quickSortWithPartition(arr, start + 1, right);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
