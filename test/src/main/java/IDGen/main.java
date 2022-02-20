package IDGen;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * mydemo
 *
 * @author zhengyouxiang
 * @date 2022/2/15 下午2:40
 */
public class main {
    public static void main(String[] args) throws IOException {


        Set<Long> ids = new ConcurrentSkipListSet<>();
        List<Long> pp = new CopyOnWriteArrayList<>();

        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    Long id = ID.getId();
                    ids.add(id);
                    pp.add(id);
                    // System.out.println(ids.size());
                }
            }).start();
        }


        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Set<Long> ids = new HashSet<>();
//        for (int j = 0;j<10;j++) {
//            for (int i = 0;i<1000;i++) {
//                ids.add(IDV2.getId());
//                // System.out.println(ids.size());
//            }
//                            }

        System.out.println(ids);
        System.out.println(pp);
    }
}
