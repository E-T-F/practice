package thread.share;

public class MyData {

    private int data;

    public synchronized void add() {
        data++;
        System.out.println(Thread.currentThread().getName() + "++ data :" + data);
    }

    public synchronized void subtract() {
        data--;
        System.out.println(Thread.currentThread().getName() + "-- data :" + data);
    }

}


