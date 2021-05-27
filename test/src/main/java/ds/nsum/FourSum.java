package ds.nsum;

import ds.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * @Auther: etf
 * @Date: 2021-05-26 23:31
 * @Description:
 */
public class FourSum {


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(Arrays.toString(new FourSum().fourSum(nums, 0).toArray()));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {

        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || size < n) {
            return res;
        }
        if (n == 2) {
            int low = start;
            int high = size - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                int left = nums[low];
                int right = nums[high];
                if (sum > target) {
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                } else if (sum < target) {
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                } else {
                    res.add(Arrays.asList(left, right));
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                    while (low < high && nums[high] == right) {
                        high--;
                    }

                }
            }
        } else {
            //n > 2 时，递归 （n - 1）sum
            for (int i = start; i < size; i++) {
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : sub) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(nums[i]);
                    res.add(temp);
                }
                // 跳过第一个数字重复的情况，否则会出现重复结果
                while (i < size - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
