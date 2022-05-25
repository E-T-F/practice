package thread.share;

public class AddRunnable implements Runnable {

    private MyData myData;

    public AddRunnable(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.add();
    }
}
