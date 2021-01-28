package ds.array.basic.classify;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 *
 * @Auther: etf
 * @Date: 2021-01-27 23:30
 * @Description:
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = 1 << 3;

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.count = 0;
        this.holder = new HashMap<>(capacity);
        this.capacity = capacity;
        this.value = (T[]) new Object[capacity];
    }

    /**
     * access obj
     *
     * @param obj
     */
    public void offer(T obj) throws Exception {
        if (obj == null) {
            throw new Exception("不支持 null");
        }

        Integer index = holder.get(obj);

        //当前列表无该值
        if (index == null) {
            if (isFull()) {
                removeAndCache(obj);
            } else {
                cache(obj, count);
            }
        } else {
            update(index);
        }

    }

    /**
     * 列表中存在该值，将其更新到数组头部
     *
     * @param index
     */
    private void update(Integer index) {
        T data = value[index];
        rightShift(index);
        value[0] = data;
        holder.put(data, 0);
    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     *
     * @param obj
     */
    private void removeAndCache(T obj) {
        T data = value[--count];
        holder.remove(data);
        cache(obj, count);
    }

    /**
     * 缓存 obj
     *
     * @param obj
     * @param end 结束位置
     */
    private void cache(T obj, int end) {
        rightShift(end);
        value[0] = obj;
        holder.put(obj, 0);
        count++;
    }

    /**
     * 右移
     *
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    private boolean isFull() {
        return count == capacity;
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }


    static class TestLRUBasedArray {
        public static void main(String[] args) throws Exception {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
        }

        private static void testWithException() throws Exception {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        private static void testSpecifiedConstructor(int capacity) throws Exception {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<>(capacity);
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        private static void testDefaultConstructor() throws Exception {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<>();
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);

        }
    }
}
