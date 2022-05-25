package alg.run0522;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int[] nums = new int[]{43, 32, 9, 53, 1, 3, 5};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = (high + low) >>> 1;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid + 1, high, temp);
        merge(nums, low, mid, high, temp);
    }

    private static void merge(int[] nums, int low, int mid, int high, int[] temp) {

        int l = low, m = mid + 1, k = low;
        while (k <= high) {
            if (l > mid) {
                temp[k++] = nums[m++];
            } else if (m > high) {
                temp[k++] = nums[l++];
            } else if (nums[l] <= nums[m]) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[m++];
            }
        }
        System.arraycopy(temp, low, nums, low, high - low + 1);

    }
}
