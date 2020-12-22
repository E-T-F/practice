package ds.array.basic.init;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 */
public class removeElement {


    /**
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement2(nums, 2));
    }




    /**
     * 快慢指针，循环遍历，快指针找寻到不等于val的数据就复制给慢指针，复制完成递增快慢指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {

        int slow = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }

        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }

    /**
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        //从两侧像中间靠拢，相遇则结束，左边找等于val的，进行交换
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return right;
    }
}
