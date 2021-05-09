package clazz;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class GrandFatherTestCase_1 {

    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        //调用祖父类方法
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                System.out.println(getClass());
                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Throwable e) {
            }

        }
    }

    public static void main(String[] args) {
        //在JDK 7 Update 9之后被视作一个潜在的安全性缺陷修正了，
        // 原因是必须保证findSpecial()查找方法版本时受到的访问约束
        // （譬如对访问控制的限制、对参数类型的限制）应与使用invokespecial指令一样，
        // 两者必须保持精确对等，包括在上面的场景中它只能访问到其直接父类中的方法版本。
        // 所以在JDK 7Update 10修正之后，运行以上代码只能得到如下结果： father
        (new GrandFatherTestCase_1().new Son()).thinking();
    }
}
