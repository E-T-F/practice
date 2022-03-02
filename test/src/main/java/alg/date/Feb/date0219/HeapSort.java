package alg.date.Feb.date0219;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 5, 6, 2, 9};

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        new HeapSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

    private void sort(int[] arr) {
        int length = arr.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子节点开始，从右到左依次调整结构
            adjustHeap(arr, i, length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    private void adjustHeap2(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int leftChild = parent * 2 + 1;
        while (leftChild < length) {
            int rightChild = leftChild + 1;
            if (rightChild < length & arr[leftChild] < arr[rightChild]) {
                leftChild++;
            }
            if (temp >= arr[leftChild]) {
                break;
            }
            arr[parent] = arr[leftChild];

            parent = leftChild;
            leftChild = leftChild * 2 + 1;
        }
        arr[parent] = temp;
    }
}
