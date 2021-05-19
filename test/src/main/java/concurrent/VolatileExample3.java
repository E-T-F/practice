package concurrent;

public class VolatileExample3 {

    static int a = 0;
    static boolean flag = false;


    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            a = 0;
            flag = false;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    flag = true;
                }
            });
            Thread m = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (flag) {
                        int i = a;
//            System.out.println(i);
                        if (i == 0) {
                            System.out.println(i);
                        }
                    }
                }
            });
            t.start();
            m.start();
            t.join();
            m.join();
        }

    }
}
