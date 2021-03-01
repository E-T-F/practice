package alg.SwordOffer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Exchange {

    /**
     * 双指针（保证原有数据顺序
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            //如果为奇数
            if ((nums[fast] & 1) == 1) {
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }

    private void swap(int[] nums, int fast, int slow) {
        int temp = nums[fast];
        nums[fast] = nums[slow];
        nums[slow] = temp;
    }


    /**
     * 不保证原有数据顺序
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            swap(nums, left, right);
        }
        return nums;
    }


    public int[] exchange3(int[] nums) {
        int odd = 0, even = 0;
        while (odd < nums.length && even < nums.length) {
            while (even < nums.length && nums[even] % 2 == 1) {
                even++;
            }

            odd = even + 1;
            while (odd < nums.length && nums[odd] % 2 == 0) {
                odd++;
            }

            if (odd < nums.length && even < nums.length) {
                swap(nums, odd, even);
            }
        }
        return nums;
    }
}
