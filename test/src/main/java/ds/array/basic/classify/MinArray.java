package ds.array.basic.classify;

public class MinArray {

    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int pivot = start + (end - start) / 2;
            if (numbers[pivot] < numbers[end]) {
                end = pivot;
            } else if (numbers[pivot] > numbers[end]) {
                start = pivot + 1;
            } else {
                end--;
            }
        }

        return numbers[start + (end - start) / 2];

    }
}
