package thread.share;

public class ShareDataDemo {


    public static void main(String[] args) {


        // 1. 将数据抽象成一个类，并将对数据的操作做为这个类的方法
        MyData myData = new MyData();
        Runnable add = new AddRunnable(myData);
        Runnable subtract = new SubTractRunnable(myData);

        for (int i = 0; i < 2; i++) {
            new Thread(add).start();
            new Thread(subtract).start();
        }



        // 2. 将Runnable 对象作为一个类的内部类
        final MyData data = new MyData();
        for (int i = 0; i < 2; i++) {
            new Thread(data::add).start();

            new Thread(data::subtract).start();
        }
    }
}
