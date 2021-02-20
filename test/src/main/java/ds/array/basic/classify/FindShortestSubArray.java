package ds.array.basic.classify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度：
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 */
public class FindShortestSubArray {


    /**
     * 值的范围已给出，使用数组实现
     * 提示：
     * nums.length 在1到 50,000 区间范围内。
     * nums[i] 是一个在 0 到 49,999 范围内的整数。
     * @param nums
     * @return
     */
    public int findShortestSubArray3(int[] nums) {
        int MAX_VAL = 50_000;
        int[] all = new int[MAX_VAL];
        int[] left = new int[MAX_VAL];
        int[] right = new int[MAX_VAL];

        Arrays.fill(left, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            max = Math.max(max, ++all[val]);
            if (left[val] == -1) {
                left[val] = i;
            }
            right[val] = i;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (all[val] == max) {
                ans = Math.min(ans, right[val] - left[val] + 1);
            }
        }
        return ans;
    }

    public int findShortestSubArray2(int[] nums) {
        //从前向后遍历，只需记录起始位置
        HashMap<Integer, Integer[]> map = new HashMap<>();
        int maxDegree = 0;
        int minWindow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
            } else {
                map.put(nums[i], new Integer[]{1, i});
            }
            if (map.get(nums[i])[0] > maxDegree) {
                maxDegree = map.get(nums[i])[0];
                minWindow = i - map.get(nums[i])[1] + 1;
            } else if (map.get(nums[i])[0] == maxDegree) {
                minWindow = Math.min(map.get(i - nums[i])[1] + 1, minWindow);
            }
        }
        return minWindow;
    }

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer[]> map = new HashMap<>();

        int maxDegree = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new Integer[]{1, i, i});
            }
            maxDegree = Math.max(maxDegree, map.get(nums[i])[0]);
        }

        int minLen = nums.length;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            Integer[] array = entry.getValue();
            if (array[0] == maxDegree) {
                minLen = Math.min(minLen, array[2] - array[1] + 1);
            }
        }
        return minLen;
    }
}
