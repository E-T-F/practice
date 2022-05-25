package thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        //八个工人有任务，只有五台机器
        int workerNum = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < workerNum; i++) {
            new Worker(i, semaphore).start();
        }
    }

    private static class Worker extends Thread {
        private int id;
        private Semaphore semaphore;
        public Worker(int num, Semaphore semaphore) {
            this.id = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + id + "开始工作");
                Thread.sleep(2000);
                System.out.println("工人" + id + "完成工作， 释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
