package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest3 {

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> queryCode("sina", "https://finance.sina.com.cn/price/"));
        CompletableFuture<String> cfQueryFromSohu = CompletableFuture.supplyAsync(() -> queryCode("sohu", "https://money.sohu.com/price/"));

        List<CompletableFuture> tasks = new ArrayList<>();
        tasks.add(cfQueryFromSina);
        tasks.add(cfQueryFromSohu);

        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(tasks.toArray(new CompletableFuture[0]));

        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> fetchPrice((String) code, "https://finance.sina.com.cn/price/"));

        CompletableFuture<Double> cfFetchFromSohu = cfQuery.thenApplyAsync((code) -> fetchPrice((String) code, "https://finance.sohu.com.cn/price/"));

        CompletableFuture.allOf(cfFetchFromSina, cfFetchFromSohu).get(1, TimeUnit.SECONDS);

//        cfFetch.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });

        System.out.println(cfFetchFromSina.getNow(0d));
        System.out.println(cfFetchFromSohu.getNow(0d));

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);

    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
