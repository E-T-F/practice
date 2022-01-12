package designPattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉延迟加载
 * 静态内部类实现
 */
public class Singleton4 {

    private final AtomicInteger id = new AtomicInteger(0);

    private Singleton4() {

    }


    public static class SingletonHolder {
        private static Singleton4 singleton = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.singleton;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
