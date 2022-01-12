package designPattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉延迟加载
 * 双重检测
 */
public class Singleton3 {

    private static Singleton3 singleton;
    private final AtomicInteger id = new AtomicInteger(0);

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
