package com.etf.annotation;

import java.lang.annotation.*;

/**
 * @author etf
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    String value() default "etf";
}
