package annotation;

import java.lang.reflect.Field;

public class TaskUtils {

    public static void main(String[] args) {
        TaskUtils.getTask(Task.class);
    }

    private static void getTask(Class<?> clazz) {
        String personInfo = "person info :";

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PersonProvider.class)) {
                PersonProvider provider = field.getAnnotation(PersonProvider.class);
                personInfo += provider.name() + "-" + provider.age() + "-" + provider.gender();
                System.out.println(personInfo);
             }
        }

    }
}
