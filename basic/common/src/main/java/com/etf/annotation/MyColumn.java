package com.etf.annotation;

import java.lang.annotation.*;

/**
 * @author etf
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyColumn {

    Type type();

    Sort sort() default Sort.none;

    enum Type {

        /**
         * query 语句
         */
        Q,

        /**
         * in 语句
         */
        IN,

        /**
         * f 语句
         */
        F,

        /**
         * sort 排序
         */
        SORT
    }

    enum Sort {
        none,

        /**
         * 升序
         */
        asc,

        /**
         * 降序
         */
        desc
    }

}
