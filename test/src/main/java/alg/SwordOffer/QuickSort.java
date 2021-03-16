package alg.SwordOffer;

import java.util.Arrays;

/**
 * @Auther: etf
 * @Date: 2021-03-16 22:40
 * @Description:
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 7};
        new QuickSort().quickSort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;

        while (left < right) {
            //两个 while执行完， i j 同时指向一个 < arr[l] 的数，
            // 因此最后再执行 swap 可以把哨兵交换到正确的位置。
            // 而如果互换这两句，那么就是 i 先向右遍历，
            // 两个 while 执行完， i j 同时指向一个 > arr[l] 的数.
            // 如果要交换写，那么同时也要把哨兵换成数组的末元素，让整个哨兵划分操作对称
            while (left < right && arr[right] >= arr[start]) {
                right--;
            }

            while (left < right && arr[left] <= arr[start]) {
                left++;
            }

            this.swap(arr, left, right);
        }
        swap(arr, start, left);
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);

    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
