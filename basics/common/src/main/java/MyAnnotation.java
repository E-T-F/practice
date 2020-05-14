import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author etf
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String[] value() default "etf";
}
