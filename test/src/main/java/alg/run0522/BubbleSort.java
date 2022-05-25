package alg.run0522;

import java.util.Arrays;

public class BubbleSort {


    public static void bubbleSort(int[] nums) {
        boolean hasChange = true;
        for (int i = 0; i < nums.length && hasChange; i++) {
            hasChange = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    hasChange = true;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{43, 32, 9, 53, 1, 3, 5};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
