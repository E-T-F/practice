package clazz;

public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    //“Human”称为变量的“静态类型”（Static Type），或者叫“外观类型”（Apparent Type）
    // 后面的“Man”则被称为变量的“实际类型”（ActualType）或者叫“运行时类型”（Runtime Type）
    // 在重载时是通过参数的静态类型而不是实际类型作为判定依据的。
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
}
