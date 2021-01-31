package ds.array.basic.classify;


/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rotate {

    /**
     * 先将所有元素翻转，这样尾部的 k mod n 个元素就被移至数组头部，
     * 然后我们再翻转 [0, k mod n-1][0,k mod n−1] 区间的元素
     * 和 [k mod n, n-1][k mod n,n−1] 区间的元素即能得到最后的答案。
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * 使用额外数组
     * 空间复杂度：O(n),时间复杂度：O(n)
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int target = (i + k) % len;
            res[target] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, len);
    }


    /**
     * 循环赋值，一轮完毕后从下一个位置进行，直到赋值的个数等于数组长度
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int count = 0;
        int i = 0;
        while (true) {
            if (count == len) {
                return;
            }
            int start = i;
            int prev = nums[i];
            do {
                int target = (start + k) % nums.length;
                int temp = nums[target];
                nums[target] = prev;
                prev = temp;
                start = target;
                count++;
            } while (i != start);
            i++;
        }
    }


    /**
     * 循环赋值，回到初始位置从下一个数字开始
     *
     * 回到了起点，即恰好走了整数数量的圈，设为 a；单次遍历了 b 个元素
     * a * n = b * k ， 即 an 一定为 n,k 的公倍数，又因为 a 要尽可能小（第一次遍历完就结束）
     * 故 an 就是 n,k 的最小公倍数 lcm(n,k)
     * 即 b = lcm(n,k) / k;
     *
     * 需要遍历总次数： n / b = n * k / lcm(n,k) = gcd(n,k)
     *
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}