package alg.run0522;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4, 1};
//        int[] nums = new int[]{3, 4, 6, 1, 7, 2, 3};

        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int random = (int) (start + (end - start + 1) * Math.random());
        swap(nums, start, random);
        quickSortPartition(nums, start, end);
    }

    private static void quickSortPartition(int[] nums, int start, int end) {
        int value = nums[start];
        int low = start, high = end;
        while (low < high) {
            while (low < high && nums[high] >= value) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= value) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = value;
        quickSort(nums, start, low - 1);
        quickSort(nums, low + 1, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
