package IDGen;

import lombok.Data;

import java.security.PublicKey;
import java.util.concurrent.atomic.AtomicLong;

/**
 * mydemo
 *
 * @author zhengyouxiang
 * @date 2022/2/15 下午3:23
 */
@Data
public class PageInfo {
    public volatile boolean isOut = false;
    public volatile long start = 1;
    public AtomicLong remind = null;

    public static PageInfo newPage(long start, long remind) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setStart(start);
        pageInfo.setRemind(new AtomicLong(remind));
        pageInfo.setOut(false);
        return pageInfo;
    }

    public long getId() {
        long nowRemind =  remind.decrementAndGet();
        if (nowRemind < 0) {
            isOut = true;
            return  -1;
         }
        return start * 10 + (10 - nowRemind);
    }
}
