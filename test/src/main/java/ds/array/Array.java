package ds.array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 *
 * @Auther: etf
 * @Date: 2020-10-29 20:07
 * @Description:
 */
public class Array {

    //数组长度
    private int size;
    //数组当前数量
    private int count;
    private int[] data;


    public Array() {
        this(10);
    }

    public Array(int capacity) {
        this.data = new int[capacity];
        this.size = capacity;
        this.count = 0;

    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > count) {
            System.out.println("索引位置不合法");
            return false;
        }

        if (count == size) {
            System.out.println("位置已满");
            return false;
        }


        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            System.out.println("索引位置不合法");
            return false;
        }

        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        count--;
        return true;
    }


    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }


    public static void main(String[] args) {
        Array array = new Array();
        array.insert(0,2);
        array.insert(0,1);
        array.insert(2, 3);
        System.out.println("find(2) :" + array.find(2));
        array.printAll();
    }

}
