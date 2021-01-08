package ds.array.basic.index;

/**
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9gogt/
 *
 * @Auther: etf
 * @Date: 2021-01-06 22:57
 * @Description:
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int s = 11;
        int[] nums = {1, 2, 3, 4, 5};
//        int s = 15;
//        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen3(s, nums));
    }

    //# 维护一个滑动窗口nums[i,j], nums[i...j] < s
    public static int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int len = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int res = 0;

        while (end < nums.length) {
            res += nums[end];
            while (res >= s) {
                len = Math.min(len, end - start + 1);
                res -= nums[start];
                start++;
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;

    }


    public static int minSubArrayLen2(int s, int[] nums) {

        int len = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= s) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    /**
     * 正整数数组，求前缀和（有序），然后通过二分查找
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen3(int s, int[] nums) {

        int len = nums.length;


        int result = Integer.MAX_VALUE;
        int[] preSums = new int[len + 1];
        preSums[0] = 0;

        for (int i = 1; i <= len; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= len; i++) {
            int target = s + preSums[i - 1];
            int bound = binarySearchVal(preSums, target);
//            int bound = Arrays.binarySearch(preSums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= len) {
                result = Math.min(result, bound - i + 1);
            }
        }


        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private static int binarySearchVal(int[] preSums, int target) {
        int left = 0;
        int right = preSums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = preSums[mid];

            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                return mid;
            }

        }
        return -(left + 1);
    }


    /**
     * 取等于s的，待验证
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLenEqualS(int s, int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            if (s == nums[0]) {
                return 1;
            }
            return 0;
        }
        int len = 0;
        int res = nums[0];
        int start = 0;
        int right = 1;
        while (right <= nums.length) {

            while (right < nums.length && res < s) {
                res += nums[right];
                right++;
            }

            while (right <= nums.length && res > s) {
                res -= nums[start];
                start++;
            }

            if (res == s) {
                int temp = right - start;
                if (len == 0 || temp < nums.length) {
                    len = temp;
                    //继续遍历
                    res -= nums[start];
                    start++;
                }
            } else if (right == nums.length) {
                return len;
            }

        }

        return len;
    }
}
