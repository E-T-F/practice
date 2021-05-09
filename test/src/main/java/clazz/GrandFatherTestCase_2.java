package clazz;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class GrandFatherTestCase_2 {


    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFatherTestCase_2.GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }


    class Son extends GrandFatherTestCase_2.Father {
        void thinking() {
            try {

                //访问保护是通过一个allowedModes的参数来控制，
                // 而且这个参数可以被设置成“TRUSTED”来绕开所有的保护措施。
                // 尽管这个参数只是在Java类库本身使用，没有开放给外部设置，但我们通过反射可以轻易打破这种限制。
                MethodType mt = MethodType.methodType(void.class);
                Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupImpl.setAccessible(true);
                MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class,"thinking", mt, GrandFather.class);
                mh.invoke(this);
            } catch (Throwable e) {
            }
        }

    }

    public static void main(String[] args) {
        (new GrandFatherTestCase_2().new Son()).thinking();
    }
}
