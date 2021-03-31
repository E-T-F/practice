package alg.SwordOffer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * @Auther: etf
 * @Date: 2021-03-31 23:00
 * @Description:
 */
public class MinNumber {
    public String minNumber(int[] nums) {

        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        quickSort(str, 0, str.length - 1);

        return String.join("", str);
    }

    private void quickSort(String[] str, int start, int end) {
        if (start >= end) {
            return;
        }

        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && (str[r] + str[start]).compareTo(str[start] + str[r]) >= 0) {
                r--;
            }
            while (l < r && (str[l] + str[start]).compareTo(str[start] + str[l]) <= 0) {
                l++;
            }
            String temp = str[l];
            str[l] = str[r];
            str[r] = temp;
        }
        String temp = str[start];
        str[start] = str[l];
        str[l] = temp;
        quickSort(str, start, l - 1);
        quickSort(str, l + 1, end);
    }


    public static void main(String[] args) {
        int[] nums = {0,9,8,7,6,5,4,3,2,1};
        System.out.println(new MinNumber().minNumber(nums));
    }
}
