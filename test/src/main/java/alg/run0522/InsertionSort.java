package alg.run0522;

import java.util.Arrays;

public class InsertionSort {
    
    
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int num = nums[i];
            while (j > 0 && num < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{43, 32, 9, 53, 1, 3, 5};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
