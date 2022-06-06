package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    public static volatile int race = 0;

    public static AtomicInteger num = new AtomicInteger(0);
    public static void increase() {
        num.getAndIncrement();
    }

    private static final int THREADS_COUNT = 10;
    static CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            countDownLatch.countDown();
            threads[i].start();
        }
        //守护线程一直存在
        while (Thread.activeCount() > 2) {
//            Thread.currentThread().getThreadGroup().list();
            Thread.yield();
        }
        countDownLatch.await();
        System.out.println(num);
    }
}
