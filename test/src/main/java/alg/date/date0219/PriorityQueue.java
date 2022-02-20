package alg.date.date0219;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable<T>> {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(10) {};
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(4);
        priorityQueue.deQueue();
        priorityQueue.enQueue(15);
        System.out.println(Arrays.toString(priorityQueue.queue));
    }
    /**
     * priority queue
     */
    private T[] queue;

    /**
     * the element size of current queue
     */
    private int size;

    /**
     * insert val to queue
     * @param val
     */
    public void enQueue(T val) {
        size++;
        queue[size] = val;
        swim(size);
    }

    /**
     * swim the position of pos in the queue
     * @param pos
     */
    private void swim(int pos) {
        while (pos > 1 && less(parent(pos), pos)) {
            exchange(pos, parent(pos));
            pos = parent(pos);
        }
    }

    /**
     * compare if queue[x] is less than queue[j]
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return queue[i].compareTo(queue[j]) < 0;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    public T deQueue() {
        T max = queue[1];
        exchange(1, size);
        queue[size] = null;
        size--;
        sink(1);
        return max;
    }

    private void sink(int pos) {
        while (left(pos) <= size) {
            //assume left node is more great
            int older = left(pos);
            if (right(pos) <= size && less(older, right(pos))) {
                older = right(pos);
            }
            //no need to sink
            if (less(older, pos)) {
                break;
            }
            exchange(older, pos);
            pos = older;
        }
    }

    private int right(int pos) {
        return pos * 2 + 1;
    }

    private int left(int pos) {
        return pos * 2;
    }

    /**
     * swap the position of i and j in the queue
     * @param i
     * @param j
     */
    private void exchange(int i, int j) {
        T temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }


    /**
     * constructor with capacity
     * @param capacity
     */
    public PriorityQueue(int capacity) {
        queue = (T[]) new Comparable[capacity + 1];
    }

    /**
     * return the max element of queue
     * @return
     */
    public T max() {
        return queue[1];
    }

    public boolean isEmpty(){
        return size == 0;
    }



}
