package clazz;

import com.mysql.jdbc.Driver;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ClassLoaderTest3 {

    public static void main(String[] args) {


//        Thread.currentThread().setContextClassLoader(ClassLoaderTest3.class.getClassLoader().getParent());

        // 很多 SPI 的实现都是通过 ServiceLoader 来去完成的。
        // ClassLoader loader 为null，使用系统类加载器
        // loader = (cl == null) ? ClassLoader.getSystemClassLoader() : cl;
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

        // JDK 的类加载器所能寻找到的所有驱动
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();

            System.out.println("driver : " + driver.getClass() + " , loader : " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上线文类加载器 : " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器 : " + ClassLoaderTest3.class.getClassLoader());

    }
}
