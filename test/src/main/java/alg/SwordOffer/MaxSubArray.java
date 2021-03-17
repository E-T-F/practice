package alg.SwordOffer;

import java.util.Arrays;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @Auther: etf
 * @Date: 2021-03-17 23:08
 * @Description:
 */
public class MaxSubArray {

    public int maxSubArrayOrigin(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(0, nums[i - 1]);
            res = Math.max(nums[i], res);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
//        dp[i] = max(val[i], dp[i - 1] + val[i]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    private int sum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
