package ds.array.basic.init;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * @Auther: etf
 * @Date: 2021-02-01 23:12
 * @Description:
 */
public class ContainsDuplicate {

    /**
     * 1. 哈希
     * 2. 排序连续相等存在重复
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> existed = new HashSet<>();
        for (int num : nums) {
            if (existed.contains(num)) {
                return true;
            }
            existed.add(num);
        }
        return false;

    }

    public boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> contains = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (contains.containsKey(nums[i])) {
                if (contains.get(nums[i]) + 1 >= 2) {
                    return true;
                }
                contains.put(nums[i], contains.get(nums[i]) + 1);
            } else {
                contains.put(nums[i], 1);
            }
        }
        return false;
    }
}
