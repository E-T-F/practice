package reflect;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("reflect.Person");
            Person person = (Person) clazz.newInstance();

            Constructor c = clazz.getDeclaredConstructor(String.class, Integer.class, String.class);
            Person p = (Person) c.newInstance("etf", 18, "男");
            System.out.println(person.getAge());
            System.out.println(JSON.toJSON(p));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
