package FalseSharing;

import java.util.concurrent.ArrayBlockingQueue;

public class CacheLineEffect {

    //cache line 一般大小是64字节，一个 long 类型占8字节
    //CPU每次从主存中拉取数据时，会把相邻的数据也存入同一个cache line。
    static long[][] arr;

    public static void main(String[] args) {
        arr = new long[1024 * 1024][];

        for (int i = 0; i < 1024 * 1024; i++) {
            arr[i] = new long[8];
            for (int j = 0; j < 8; j++) {
                arr[i][j] = 1L;
            }
        }

        long sum = 0L;
        long marked = System.currentTimeMillis();
        for (int i = 0; i < 1024 * 1024; i++) {
            for (int j = 0; j < 8; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

        sum = 0;
        marked = System.currentTimeMillis();
        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 1024 * 1024; j++) {
                sum += arr[j][i];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
    }



//    ArrayBlockingQueue
}
