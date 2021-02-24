package alg.SwordOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Auther: etf
 * @Date: 2021-02-24 00:13
 * @Description:
 */
public class CQueue {

    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public CQueue() {
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        deque1.push(value);

    }

    public int deleteHead() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.push(deque1.pop());
            }
        }
        if (deque2.isEmpty()) {
            return -1;
        } else {
            return deque2.pop();
        }

    }
}