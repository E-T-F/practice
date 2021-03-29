package alg.SwordOffer;

import java.util.PriorityQueue;

/**
 * @Auther: etf
 * @Date: 2021-03-29 21:48
 * @Description:
 */
public class MedianFinder {

    PriorityQueue<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        //小顶堆，保存较大的部分
        A = new PriorityQueue<>();
        //大顶堆
        B = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            A.offer(num);
            B.offer(A.poll());
        } else {
            B.offer(num);
            A.offer(B.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : B.peek();
    }
}
