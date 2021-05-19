package concurrent;

public class VolatileExample2 {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        for (;;) {
            j++;
            x = 0; y = 0; a = 0; b = 0;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            t.start();
            Thread m = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            m.start();

            t.join();
            m.join();

            if (x == 0 && y == 0) {
                System.out.println(j);
                break;
            }
        }

    }
}
