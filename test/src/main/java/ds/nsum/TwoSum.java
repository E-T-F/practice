package ds.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设输入一个数组 nums 和一个目标和 target，请你返回 nums 中能够
 * 凑出 target 的两个元素的值，比如输入 nums = [1,3,5,6], target = 9，
 * 那么算法返回两个元素 [3,6]。可以假设只有且仅有一对儿元素可以凑出 target。
 *
 * @Auther: etf
 * @Date: 2021-05-26 21:58
 * @Description:
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 6, 7, 2, 7};
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 9).toArray()));
    }

    public List<List<Integer>> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low];
            int right = nums[high];
            if (sum > target) {
                high--;
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else if (sum < target) {
                low++;
                while (low < high && nums[low] == left) {
                    low++;
                }
            } else if (sum == target) {
                res.add(Arrays.asList(left, right));
                while (low < high && nums[high] == right) {
                    high--;
                }
                while (low < high && nums[low] == left) {
                    low++;
                }
            }
        }
        return res;

    }


}
