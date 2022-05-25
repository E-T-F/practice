package javaTest;

import lombok.SneakyThrows;
import org.openjdk.jol.info.ClassLayout;

public class MarkWordDemo {

    public static void main(String[] args) throws InterruptedException {
        L l = new L();  //new 一个对象
        System.out.println("main thread:" + ClassLayout.parseInstance(l).toPrintable());//输出 l对象 的布局

        Thread.sleep(1000l);

        new Thread(() -> {
            try {
                synchronized (l) {
                    Thread.sleep(3000l);
                    System.out.println("thread1:" + ClassLayout.parseInstance(l).toPrintable());//输出 l对象 的布局
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                synchronized (l) {
                    Thread.sleep(2000l);
                    System.out.println("thread2:" + ClassLayout.parseInstance(l).toPrintable());//输出 l对象 的布局
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

//
//        Thread.sleep(5000l);
//        synchronized (l) {
//            System.out.println("main thread:" + ClassLayout.parseInstance(l).toPrintable());//输出 l对象 的布局
//        }
    }
}

//对象类
class L {
    private boolean myboolean = true;
}
