package concurrent;

public class VolatileExample {

    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a;
//            System.out.println(i);

            if (i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {

            VolatileExample v = new VolatileExample();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    v.writer();
                }
            });
            Thread m = new Thread(new Runnable() {
                @Override
                public void run() {
                    v.reader();
                }
            });

            t.start();
            m.start();

            t.join();
            m.join();
        }


    }
}
