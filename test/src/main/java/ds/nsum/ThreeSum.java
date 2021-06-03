package ds.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * @Auther: etf
 * @Date: 2021-05-26 22:31
 * @Description:
 */
public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(new ThreeSum().threeSum(nums).toArray()));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);

    }

    private List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuple = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> list : tuple) {
                res.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int low = start, high = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low];
            int right = nums[high];

            if (sum > target) {
                high--;
                while (low < high && right == nums[high]) {
                    high--;
                }
            } else if (sum < target) {
                low++;
                while (low < high && left == nums[low]) {
                    low++;
                }
            } else if (sum == target) {
                res.add(Arrays.asList(left, right));
                while (low < high && right == nums[high]) {
                    high--;
                }
                while (low < high && left == nums[low]) {
                    low++;
                }
            }
        }
        return res;
    }
}
