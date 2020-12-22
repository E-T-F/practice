package ds.array.basic.init;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9a60t/
 */
public class removeDuplicates {

    public static void main(String[] args) {

//         int[] nums = {1,1,2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int len = removeDuplicates(nums);
        int len = removeDuplicatesForSorted(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }




    /**
     * 如果是排序数组时使用
     * @param nums
     * @return
     */
    public static int removeDuplicatesForSorted(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }


    /**
     * 如果不是排序数组时使用
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nonInclude(nums, left, right)) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    private static boolean nonInclude(int[] nums, int left, int right) {
        for (int i = 0; i <= left; i++) {
            if (nums[i] == nums[right]) {
                return false;
            }
        }
        return true;
    }

}
