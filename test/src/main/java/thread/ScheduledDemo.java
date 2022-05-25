package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledDemo {

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
//        pool.schedule(new MyCallable(1), 3, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(new MyRunnable(), 10, 3, TimeUnit.SECONDS);
    }
}
