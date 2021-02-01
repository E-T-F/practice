package ds.array.basic.init;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 *
 * @Auther: etf
 * @Date: 2021-02-01 23:25
 * @Description:
 */
public class SingleNumber {

    /**
     * 位运算
     *
     * 任何数和 0 做异或运算，结果仍然是原来的数
     * 任何数和其自身做异或运算，结果是 0
     * 异或运算满足交换律和结合律，
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


    public int singleNumber2(int[] nums) {
        Set<Integer> single = new HashSet<>();
        for (int num : nums) {
            if (single.contains(num)) {
                single.remove(num);
            } else {
                single.add(num);
            }
        }
        return single.iterator().next();
//        return (int) single.toArray()[0];
    }


    public int singleNumber3(int[] nums) {
        int sum2 = 0;
        Set<Integer> single = new HashSet<>();
        for (int num : nums) {
            single.add(num);
            sum2 += num;
        }
        int sum1 = single.stream().mapToInt(Integer::intValue).sum();
        return sum1 * 2 - sum2;
    }
}
