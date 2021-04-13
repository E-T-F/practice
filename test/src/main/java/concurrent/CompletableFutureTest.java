package concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);
        //如果执行成功
        cf.thenAccept(result -> System.out.println("price:" + result));
        //执行异常
        cf.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        Thread.sleep(2000);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
