package designPattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉延迟加载
 * 频繁加锁、释放锁及并发度低
 */
public class Singleton2 {

    private static Singleton2 singleton;
    private final AtomicInteger id = new AtomicInteger(0);

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
