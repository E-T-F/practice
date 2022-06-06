package alg.run0522;

import java.util.Arrays;

/**
 * 21. 较小的三数之和 题目描述
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target
 * 成立的三元组 i,j,k 个数。
 * 示例:
 */
public class ThreeSumSmaller {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 1, 3};
        System.out.println(threeSumSmaller(nums, 2));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        return solve(nums, 3, 0, nums.length - 1, target);
    }

    private static int solve(int[] nums, int n, int start, int end, int target) {
        int count = 0;
        if (n < 2) {
            return count;
        }
        if (n == 2) {
            while (start < end) {
                int val = nums[start] + nums[end];
                if (target <= val) {
                    end--;
                } else {
                    //满足
                    count += end - start;
                    start++;
                }
            }
        } else {
            for (int i = 0; i <= nums.length - n; i++) {
                count += solve(nums, n - 1, i + 1, end, target - nums[i]);
            }
        }
        return count;
    }
}
