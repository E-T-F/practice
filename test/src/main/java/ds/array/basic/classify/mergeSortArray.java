package ds.array.basic.classify;

import java.util.Arrays;

/**
 * @Auther: etf
 * @Date: 2020-12-29 23:44
 * @Description:
 */
public class mergeSortArray {


    public static void main(String[] args) {
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge3(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

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
}
