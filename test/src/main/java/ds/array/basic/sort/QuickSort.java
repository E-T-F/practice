package ds.array.basic.sort;

import ds.array.CommonUtils;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};

        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void quickSort(int[] nums) {
        quickSortWithRandomPartition(nums, 0, nums.length - 1);

    }

    private static void quickSortWithRandomPartition(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pos = (int) (Math.random() * (end - start + 1)) + start;
        CommonUtils.swap(nums, start, pos);
        quickSortWithPartition(nums, start, end);
    }


    private static void quickSortWithPartition(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int val = nums[low];
        int start = low;
        int end = high;
        while (start < end) {
            while (start < end && val <= nums[end]) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && val >= nums[start]) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = val;
        quickSortWithRandomPartition(nums, low, start - 1);
        quickSortWithRandomPartition(nums, start + 1, high);

    }


}
