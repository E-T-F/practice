package thread.share;

public class SubTractRunnable implements Runnable {

    private MyData myData;

    public SubTractRunnable(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.subtract();
    }
}
