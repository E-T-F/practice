package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SafeCount {

    private static int i = 0;
    private AtomicInteger actomicI = new AtomicInteger(0);

    public static void main(String[] args) {

        SafeCount counter = new SafeCount();
        List<Thread> list = new ArrayList<Thread>(100);
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        counter.count();
                        counter.safeCount();

                    }
                }
            });
            list.add(t);
        }

        for (Thread t : list) {
            t.start();
        }

        for (Thread t : list) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(i);
        System.out.println(counter.actomicI.get());

    }


    private void safeCount() {
        for (;;) {
            int i = actomicI.get();
            boolean suc = actomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    private static void count() {
        i++;
    }
}
