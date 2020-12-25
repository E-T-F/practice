package ds.array.basic.classify;

import ds.array.CommonUtils;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x90rpm/
 */
public class findKthLargest {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        return findKth(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int findKth(int[] nums, int start, int end, int pos) {
        int val = RandomPartition(nums, start, end);
        if (pos == val) {
            return nums[val];
        } else {
            return val > pos ? findKth(nums, start, val - 1, pos) : findKth(nums, val + 1, end, pos);
        }
    }

    private static int RandomPartition(int[] nums, int start, int end) {
        int randomIndex = (int) (Math.random() * (end - start) + start);
        CommonUtils.swap(nums, randomIndex, start);
        return Partition(nums, start, end);
    }

    private static int Partition(int[] nums, int start, int end) {
        int value = nums[start];
        int low = start;
        int high = end;

        while (low < high) {
            while (low < high && nums[high] >= value) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= value) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = value;
        return low;
    }
}
