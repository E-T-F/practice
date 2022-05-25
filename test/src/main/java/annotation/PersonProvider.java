package annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonProvider {

    public String name() default "et" ;
    public int age() default 1;
    public String gender() default "";


    public enum Gender {
        Male,
        Female

    }
}
