package thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            for (int j = 0; j < 100; j++) {
                System.out.println(Thread.currentThread().getName() + "running:" + j);
            }
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


