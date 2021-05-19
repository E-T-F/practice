package clazz;

public class ClassLoaderTest2 {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // # 伪代码： 线程上下文加载器破坏双亲委派模式
        // 当高层提供了统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，
        // 就必须要通过线程上下文类加载器来帮助高层的 ClassLoader 找到并加载该类。
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {

            // 获取当前线程    调用set方法将你想要设置成为类加载器的参数设置进去（targetTccl）
//            Thread.currentThread().setContextClassLoader(targetTccl);
            //  在MyMethod中显然会调用Thread.currentThread().getContextClassLoader()  把targetTccl拿出来进行类的加载
            //  myMethod();

        } finally {

            // 运行完后再把线程上下文类加载器还原
            Thread.currentThread().setContextClassLoader(classLoader);
        }
    }
}
