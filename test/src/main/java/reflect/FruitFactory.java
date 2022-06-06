package reflect;

public class FruitFactory {

    // IoC 的实现原理就是工厂模式加反射机制。
    public static Fruit getInstance(String className) {
        Fruit f = null;

        try {
            f = (Fruit) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void main(String[] args) {
        Fruit f = getInstance("reflect.Orange");
        if (f != null) {
            f.eat();
        }
    }
}
