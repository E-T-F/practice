package ds.array.basic.classify;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 说明：
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9lhe7/
 */
public class mergeSortedArray {


    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3, n = 3;
        merge2(num1, m, num2, n);

        System.out.println(Arrays.toString(num1));
    }




    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void merge4(int[] nums1, int m, int[] nums2, int n) {

        if (n < 1) {
            return;
        }

        if (m < 1) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }

        int index1 = m - 1;
        int index2 = n - 1;
        int total = m + n - 1;

        while (total >= 0) {
            if ((index1 >= 0 &&
                    (index2 < 0 || nums1[index1] > nums2[index2]))) {
                nums1[total] = nums1[index1];
                index1--;
            } else if ((index2 >= 0
                    && (index1 < 0 || nums2[index2] >= nums1[index1]))) {
                nums1[total] = nums2[index2];
                index2--;
            }
            total--;
        }

    }


    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

        if (n < 1) {
            return;
        }

        if (m < 1) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }

        int index1 = m - 1;
        int index2 = n - 1;
        int pos = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            nums1[pos--] = nums1[index1] > nums2[index2] ? nums1[index1--] : nums2[index2--];
        }

        if (index2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
        }

    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m];

        System.arraycopy(nums1, 0, temp, 0, m);

        int index1 = 0;
        int index2 = 0;
        int pos = 0;
        while (index1 < m && index2 < n) {
            if (temp[index1] > nums2[index2]) {
                nums1[pos] = nums2[index2];
                index2++;
            } else {
                nums1[pos] = temp[index1];
                index1++;
            }
            pos++;
            System.out.println(Arrays.toString(nums1));
        }

        if (index1 < m) {
            System.arraycopy(temp, index1, nums1, pos, m - index1);
        }

        if (index2 < n) {
            System.arraycopy(nums2, index2, nums1, pos, n - index2);
        }
    }

}
