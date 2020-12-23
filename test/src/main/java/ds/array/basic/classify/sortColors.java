package ds.array.basic.classify;

import java.util.Arrays;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9wv2h/
 */
public class sortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);

        System.out.println(Arrays.toString(nums));


    }

    public static void sortColorsForPartition(int[] nums) {
        int left = 0;
        int right = nums.length;
        int i = 0;

        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                right--;
                swap(nums, i, right);
            }
        }
    }

}
