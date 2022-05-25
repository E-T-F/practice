package alg.run0522;

import java.util.Arrays;

public class SelectionSort {


    public static void selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{43, 32, 9, 53, 1, 3, 5};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
