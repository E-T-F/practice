package thread;

public class ContextTest implements Runnable {
    private Thread thread;

    public ContextTest() {
        this.thread = new Thread(this);
        this.thread.start();
    }
    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();//返回此线程的上下文类加载器
        //this.thread.setContextClassLoader(classLoader);
        System.out.println("Class :"+classLoader.getClass());
        System.out.println("Parent :"+classLoader.getParent().getClass());
        System.out.println(Thread.class.getClassLoader());
    }

    public static void main(String[] args) {
        new ContextTest();
    }

    //线程上下文加载器一般使用模式(获取–使用–还原)
    public void test() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
//            Thread.currentThread ().setContextClassLoader(targetTccl) ;
//            myMethod();
        }finally {
            Thread.currentThread ().setContextClassLoader (classLoader) ;
        }

    }
}