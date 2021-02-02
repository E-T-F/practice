package ds.array.basic.classify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: etf
 * @Date: 2021-02-02 22:11
 * @Description:
 */
public class Intersect {

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2};
        int[] nums2 = {1, 1};
        System.out.println(new Intersect().intersect(nums1, nums2).toString());

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        boolean max = nums1.length > nums2.length;
        if (max) {
            intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res.add(num);
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        List<Integer> result = new ArrayList<>();
        //int[] intersection = new int[Math.min(length1, length2)];
        //int index = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                result.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
//        return Arrays.copyOfRange(intersection, 0, index);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}