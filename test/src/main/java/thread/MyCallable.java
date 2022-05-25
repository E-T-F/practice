package thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    private int i;
    @Override
    public Object call() throws Exception {
        i++;
        System.out.println(i);
        return i;
    }

    public MyCallable(int i) {
        this.i = i;
    }
}
