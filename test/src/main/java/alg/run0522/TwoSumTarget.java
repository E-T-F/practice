package alg.run0522;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumTarget {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSumTarget(nums, 9).get(0)));
    }
    public static List<int[]> twoSumTarget(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (target < sum) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else if (target > sum) {
                while (low < high && nums[low] == left) {
                    low++;
                }
            } else {
                res.add(new int[]{low, high});
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return res;
    }
}
