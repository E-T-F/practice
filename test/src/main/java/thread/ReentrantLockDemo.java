package thread;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private LinkedList<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();

        Thread t = new Thread(demo::addTask);


        Thread t2 = new Thread(demo::getTask);


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(t);
            executorService.submit(t2);
        }


    }

    public void addTask() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                queue.add(String.valueOf(i));
            }
            condition.signal();
        } finally {
            lock.unlock();
        }
    }



    public void getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            for (int i = 0; i < 5; i++) {
                String s = queue.poll();
                System.out.println(Thread.currentThread().getName() + "poll : " + s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
