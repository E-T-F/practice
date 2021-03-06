package alg.SwordOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @Auther: etf
 * @Date: 2021-03-15 22:47
 * @Description:
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2};
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(arr, 2)));

    }
    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            Integer val = queue.peek();
            if (val > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }


        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
