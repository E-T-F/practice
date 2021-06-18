package designPattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉延迟加载
 * enum实现
 */
public enum Singleton5 {

    INSTANCE;
    private final AtomicInteger id = new AtomicInteger(0);


    public static Singleton5 getInstance() {
        return INSTANCE;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
