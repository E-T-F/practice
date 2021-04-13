package concurrent;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

public class FutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<BigDecimal> future = es.submit(new Task());
        System.out.println(future.get());
    }



    public static class Task implements Callable<BigDecimal> {
        @Override
        public BigDecimal call() throws Exception {
            Thread.sleep(1000);
            double random = Math.random() * 20 + 6;
            return new BigDecimal(random).setScale(2, RoundingMode.DOWN);
        }
    }
}
