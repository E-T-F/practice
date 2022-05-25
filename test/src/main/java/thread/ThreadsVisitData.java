package thread;

public class ThreadsVisitData {

    public static ShareData share = new ShareData();

    public static void main(String[] args) {
        //final ShareData share = new ShareData();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    share.addx();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    share.subx();
                }
            }
        }).start();
    }
}


class ShareData {
    private int x = 0;

    public synchronized void addx() {
        x++;
        System.out.println("x++ : " + x);
    }

    public synchronized void subx() {
        x--;
        System.out.println("x-- : " + x);
    }
}