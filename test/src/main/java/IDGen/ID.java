package IDGen;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * mydemo
 *
 * @author zhengyouxiang
 * @date 2022/2/15 下午2:07
 */
public class ID {
    private static int page = -1;
    private static volatile long start = 1;
    private static AtomicLong remind = null;
    private static Lock lock = new ReentrantLock();
    public static long getId() {
        if (null == remind) {
            lock.lock();
            try {
                if (null == remind) {
                    remind = new AtomicLong(10);
                    start = getIdFromDb();

                    System.out.println("-------");
                }
            } finally {
                lock.unlock();
            }
        }

        long tempStart = start;
        long nowRemind =  remind.decrementAndGet();

        if (nowRemind < 0) {
            lock.lock();// -1 -2 -3 ... -20。
            try {
                for (;;) {
                    long tempStart1 = start;
                    nowRemind = remind.decrementAndGet();
                   if (nowRemind < 0) {
                       start = getIdFromDb();


                       remind = new AtomicLong(10);
                   } else {
                       return  tempStart1 * 10 + (10 - nowRemind);
                   }
                }
            } finally {
                lock.unlock();
            }
        }

        return  tempStart * 10 + (10 - nowRemind);
    }


    public static synchronized long getIdFromDb() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ++ page;
    }
}
