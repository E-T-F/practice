package designPattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 饿汉
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();
    private final AtomicInteger id = new AtomicInteger(0);

    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
