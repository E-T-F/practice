package concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest2 {

    public static void main(String[] args) throws InterruptedException {
        //串行执行
        //第一个任务
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("中国石油"));
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> fetchPrice(code));

        cfFetch.thenAccept(result -> {
            System.out.println("price :" + result);
        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);

    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

    private static String queryCode(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println(code);
        return "601857";
    }
}
