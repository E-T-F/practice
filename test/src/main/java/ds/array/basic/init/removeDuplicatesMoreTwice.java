package ds.array.basic.init;

import java.util.Arrays;

/**
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 */
public class removeDuplicatesMoreTwice {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int len = removeDuplicates(nums);
        int len = removeDuplicatesMoreTwice2(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicatesMoreTwice(int[] nums) {
        int left = 0;
        int count = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[left]) {
                if (count < 2) {
                    left++;
                    nums[left] = nums[right];
                }
                count++;
            } else {
                count = 1;
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }


    //时间复杂度：O(N)
    public static int removeDuplicatesMoreTwice2(int[] nums) {
        int left = 0;
        int count = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[left]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }


    //时间复杂度：O(N^2)
    public static int removeDuplicatesMoreTwice3(int[] nums) {
        int i = 1;
        int count = 1;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    removeElement(nums, i);
                    i--;
                    len--;
                }
            } else {
                count = 1;
            }
            i++;
        }
        return i;

    }


    private static int[] removeElement(int[] nums, int num) {
        for (int i = num + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        return nums;
    }
}
