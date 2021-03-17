package alg.SwordOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @Auther: etf
 * @Date: 2021-03-15 22:47
 * @Description:
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2};
//        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(arr, 2)));
        new GetLeastNumbers().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr.length <= 1 || k >= arr.length) {
            return arr;
        }
        return quickSortOpt(arr, 0, arr.length - 1, k);
    }

    private int[] quickSortOpt(int[] arr, int left, int right, int k) {

        int l = left;
        int r = right;

        while (l < r) {
            while (l < r && arr[r] >= arr[left]) {
                r--;
            }
            while (l < r && arr[l] <= arr[left]) {
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, l, left);
        //优化操作
        if (l > k) {
            //左边递归寻找
            quickSortOpt(arr, left, l, k);
        } else if (l < k) {
            quickSortOpt(arr, l + 1, right, k);
        }
        return Arrays.copyOf(arr, k);
    }


    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        quickSort(arr, 0, arr.length - 1);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    private void quickSort(int[] arr, int l, int r) {

        int left = l;
        int right = r;

        if (left >= right) {
            return;
        }
        int val = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= val) {
                right--;
            }
//            arr[left] = arr[right];
            while (left < right && arr[left] <= val) {
                left++;
            }
//            arr[right] = arr[left];
            swap(arr, left, right);
        }
        swap(arr, left, l);
//        arr[left] = val;
        quickSort(arr, l, left - 1);
        quickSort(arr, left + 1, r);
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
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

    //给出了范围，可用计数排序，0 <= arr[i] <= 10000
    public int[] getLeastNumbers4(int[] arr, int k) {

        if (k >= arr.length) {
            return arr;
        }

        int[] counter = new int[10001];

        for (int val : arr) {
            counter[val]++;
        }

        int count = 0;
        int[] res = new int[k];
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0 && count < k) {
                res[count] = i;
                counter[i]--;
                count++;
            }

            if (count == k) {
                break;
            }
        }
        return res;
    }
}
