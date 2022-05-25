package thread;

public class DeadLock implements Runnable {

    public int flag = 1;

    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("o1 -> o2");
                }
            }
        }

        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("o2 -> o1");
                }
            }
        }
    }

    public static void main(String[] args) {
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
//        DeadLock d1 = new DeadLock();
//        DeadLock d2 = new DeadLock();
//        d1.flag = 1;
//        d2.flag = 0;
//        new Thread(d1).start();
//        new Thread(d2).start();
    }
}
