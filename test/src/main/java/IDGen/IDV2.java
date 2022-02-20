package IDGen;//package zyx.mydemo.ide;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * mydemo
 *
 * @author zhengyouxiang
 * @date 2022/2/15 下午2:07
 */
public class IDV2 {
    private static volatile int page = -1;
    private static Lock lock = new ReentrantLock();
    private static volatile PageInfo pageInfo;
    public static long getId() {
        if (null == pageInfo) {
            lock.lock();
            try {
                if (null == pageInfo) {
                    pageInfo = PageInfo.newPage(getIdFromDb(), 10);
                    System.out.println("-------");
                }
            } finally {
                lock.unlock();
            }
        }

        long id = pageInfo.getId();

        if (pageInfo.isOut) {
            lock.lock();// -1 -2 -3 ... -20。
            try {
                for (;;) {
                    if (pageInfo.isOut) {
                        pageInfo =  PageInfo.newPage(getIdFromDb(), 10);
                    }

                    id = pageInfo.getId();
                    if (pageInfo.isOut) {
                        continue;
                    }

                    break;
                }
            } finally {
                lock.unlock();
            }
        }

        return  id;
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
