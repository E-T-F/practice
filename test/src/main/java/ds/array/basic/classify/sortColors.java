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
//        输入：nums = [2,0,2,1,1,0]
//        输出：[0,0,1,1,2,2]

        int[] nums = {1,2,0};
        SortColorsForThisAlg3(nums);
        System.out.println(Arrays.toString(nums));
    }



    /**
     * 两个指针，一个指向0插入的位置，一个指向1插入的位置
     * 如果是0，0和1的索引位置都向后移动，并且当0的index小于1的index，说明区间内存在1需要将换到后面的1换回来
     * @param nums
     */
    public static void SortColorsForThisAlg2(int[] nums) {
        int zeroIndex = 0;
        int oneIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, zeroIndex, i);
                //如果0的索引小于1的索引，说明存在1，并且被换到了最后，需换回来
                if (zeroIndex < oneIndex) {
                    swap(nums, oneIndex, i);
                }
                zeroIndex++;
                oneIndex++;
            } else if (nums[i] == 1) {
                swap(nums, oneIndex, i);
                oneIndex++;
            }
        }
    }


    /**
     * 两个指针，一个指向0插入的位置（头部开始），一个指向2插入的位置（尾部开始）
     * 但如果是
     * @param nums
     */
    public static void SortColorsForThisAlg3(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for (int i = 0; i <= twoIndex; i++) {

            while (i <= twoIndex && nums[i] == 2) {
                swap(nums, twoIndex, i);
                twoIndex--;
            }
            if (nums[i] == 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
            }
        }
    }

    public static void SortColorsForThisAlg(int[] nums) {
        int cursor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, cursor);
                cursor++;
            }
        }
        for (int i = cursor; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, cursor);
                cursor++;
            }
        }

    }

    public static void bubbleSortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
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

    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
