package thread;

import java.util.concurrent.ConcurrentHashMap;

public class InterruptDemo extends Thread {


    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                //非阻塞过程中通过判断中断标志来退出
                while (!isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + "start sleep");
//                    try {
//                        System.out.println(Thread.currentThread().getName() + "start sleep");
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println(e);
//                        //捕获到异常之后，执行break跳出循环。
//                        break;
//                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "start sleep");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(e);
                        break;
                    }
                    thread1.interrupt();
                }
            }
        };

        thread1.start();
        thread2.start();
    }

    private int i;

    public InterruptDemo(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName() + "start sleep" + i);
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
                break;
            }
        }
    }
}
