package ds.array;

import java.util.Arrays;

/**
 * @Auther: etf
 * @Date: 2020-10-30 09:25
 * @Description:
 */
public class GenericArray<T> {

    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 当前数组数量
     *
     * @return
     */
    public int count() {
        return size;
    }


    /**
     * 当前数组容量
     *
     * @return
     */
    public int capacity() {
        return data.length;
    }

    /**
     * 修改指定索引位置值
     *
     * @param index
     * @param value
     */
    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T value) {
        for (T val : data) {
            if (val.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取对应元素的下标, 未找到，返回 -1
     *
     * @param value
     * @return
     */
    public int find(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }


    public void add(int index, T value) {
        checkIndexForAdd(index);
        if (size == data.length) {
            resize(2 * size);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = value;
        size++;
    }


    public void addFirst(T value) {
        add(0, value);
    }

    public void addLast(T value) {
        add(size, value);
    }


    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        //缩容
        if (size < data.length / 4 && size / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T value) {
        int index = find(value);
        if (index != -1) {
            remove(index);
        }
    }


    @Override
    public String toString() {
        return "GenericArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + data.length +
                '}';
    }

    private void checkIndexForAdd(int index) {
        // 等于size时进行扩容
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Require index >=0 and index <= size.");

        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Require index >=0 and index < size.");
        }
    }

    /**
     * 扩展原数组，时间复杂度O(n)
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
