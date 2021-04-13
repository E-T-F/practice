package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            pool.submit(new Task(String.valueOf(i)));
        }
    }

    static class Task implements Runnable{

        public final String name;
        public Task (String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("start:" + name);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end:" + name);
        }
    }
}
