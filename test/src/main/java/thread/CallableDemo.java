package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskSize = 10;
        List<Future> list = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i);
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();
        for (Future f : list) {
            System.out.println(f.get());
        }
    }
}
