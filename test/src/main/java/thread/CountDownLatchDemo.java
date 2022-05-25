package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        CountDownLatch latch = new CountDownLatch(2);
        demo.privateTaskExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "结束执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        demo.privateTaskExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "结束执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        try {
            boolean flag = latch.await(3000, TimeUnit.MILLISECONDS);
            if (!flag) {
                System.out.println("主线程等待线程池超时");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.privateTaskExecutor.shutdown();
        System.out.println("finished");
    }





    private static final int MIN_EXECUTOR_SIZE = 16;
    private static final int MAX_EXECUTOR_SIZE = 32;
    private static final long KEEP_ACTIVE_TIME = 1L;
    private static final int QUEUE_SIZE = 200;
    private ThreadFactory threadFactory = new ThreadFactory() {
        AtomicInteger integer = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(String.format("%s_%s", "privateTaskThread", String.valueOf(integer.getAndIncrement())));
            return t;

        }
    };
    private ExecutorService privateTaskExecutor = new ThreadPoolExecutor(MIN_EXECUTOR_SIZE, MAX_EXECUTOR_SIZE,
            KEEP_ACTIVE_TIME, TimeUnit.MINUTES, new LinkedBlockingDeque<>(QUEUE_SIZE), threadFactory);

}
