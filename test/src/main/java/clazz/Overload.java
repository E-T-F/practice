package clazz;

import java.io.Serializable;


public class Overload {



    //可见变长参数的重载优先级是最低的
    //自动转型还能继续发生多次，按照char>int>long>float>double的顺序转型进行匹配
    //当自动装箱之后发现还是找不到装箱类，但是找到了装箱类所实现的接口类型，所以紧接着又发生一次自动转型。
    // char可以转型成int，但是Character是绝对不会转型为Integer的，它只能安全地转型为它实现的接口或父类
    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("hello char ...");
    }

    public static void sayHello(int... arg) {
        System.out.println("hello int ...");
    }

    public static void sayHello(Comparable<Character> arg) {
        System.out.println("hello Comparable<Character>");
    }


    public static void sayHello(double arg) {
        System.out.println("hello double ");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }

}
