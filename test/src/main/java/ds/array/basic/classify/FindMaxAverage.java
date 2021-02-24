package ds.array.basic.classify;

/**
 * @Auther: etf
 * @Date: 2021-02-04 23:31
 * @Description:
 */
public class FindMaxAverage {


    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0 * maxSum / k;
    }

    /**
     * 有负值不可
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage2(int[] nums, int k) {

        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] += nums[i - 1];
        }
        double max = 0;
        for (int i = 0; i <= preSum.length - k; i++) {
            max = Math.max(max, (preSum[i + k] - preSum[i]) / k);
        }
        return max;
    }
}
