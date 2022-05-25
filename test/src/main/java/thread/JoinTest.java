package thread;

public class JoinTest {

    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1" + Thread.currentThread().getName());
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("t2 start" + Thread.currentThread().getName());
                    System.out.println("t2");
                    System.out.println("t2 end" + Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println("t3 start" + Thread.currentThread().getName());
                    System.out.println("t3");
                    System.out.println("t3 end" + Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();
        thread2.start();
        thread1.start();
    }
}
